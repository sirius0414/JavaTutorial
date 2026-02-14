package org.siyue.spring.lifecycle;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PaymentService implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean {

    private String beanName;
    private ApplicationContext applicationContext;
    private final List<RiskRule> mergedRules = new ArrayList<>();
    private final Set<String> emergencyBlacklistIp = new HashSet<>();
    private final Map<String, Integer> merchantBaseRisk = new LinkedHashMap<>();

    private int manualReviewThreshold = 70;

    public void setManualReviewThreshold(int manualReviewThreshold) {
        this.manualReviewThreshold = manualReviewThreshold;
    }

    @Override
    public void setBeanName(String name) {
        this.beanName = name;
        System.out.println("[Aware] BeanNameAware#setBeanName -> " + name);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("[Aware] BeanFactoryAware#setBeanFactory -> " + beanFactory.getClass().getSimpleName());
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
        System.out.println("[Aware] ApplicationContextAware#setApplicationContext -> " + applicationContext.getClass().getSimpleName());
    }

    @PostConstruct
    public void prepareEmergencyData() {
        // 模拟“初始化前”就要准备好的兜底数据（比如风控黑名单）
        emergencyBlacklistIp.add("43.99.0.1");
        emergencyBlacklistIp.add("10.13.7.9");
        merchantBaseRisk.put("m-video", 10);
        merchantBaseRisk.put("m-digital", 20);
        merchantBaseRisk.put("m-oversea", 35);
        System.out.println("[BeforeInitialization BPP phase] @PostConstruct loaded emergency blacklist/base-risk profile");
    }

    @Override
    public void afterPropertiesSet() {
        // 业务逻辑：通过 ApplicationContext 聚合多个规则提供者
        Map<String, RiskRuleProvider> providers = applicationContext.getBeansOfType(RiskRuleProvider.class);
        providers.values().stream()
                .map(RiskRuleProvider::provideRules)
                .forEach(mergedRules::addAll);

        if (mergedRules.isEmpty()) {
            throw new IllegalStateException("risk rule providers are required");
        }

        System.out.println("[invokeInitMethods] afterPropertiesSet merged rule count = " + mergedRules.size());
    }

    public void warmUpRiskCache() {
        // 业务逻辑：模拟 init-method 里做缓存预热/模型预热
        int maxBase = merchantBaseRisk.values().stream().max(Integer::compareTo).orElse(0);
        System.out.println("[invokeInitMethods] init-method(warmUpRiskCache) done, maxMerchantBaseRisk=" + maxBase);
    }

    public PaymentDecision pay(PaymentRequest request) {
        int score = merchantBaseRisk.getOrDefault(request.merchantId(), 15);
        List<String> hitRules = new ArrayList<>();

        if (emergencyBlacklistIp.contains(request.clientIp())) {
            score += 80;
            hitRules.add("emergency-blacklist-ip");
        }

        for (RiskRule rule : mergedRules) {
            int delta = rule.hitScore(request);
            if (delta > 0) {
                score += delta;
                hitRules.add(rule.name());
            }
        }

        String action = score >= manualReviewThreshold ? "MANUAL_REVIEW" : "PASS";
        String reason = hitRules.isEmpty() ? "no-risk-hit" : String.join(",", hitRules);

        System.out.println("[Business] " + beanName + " order=" + request.orderNo()
                + " score=" + score + " action=" + action + " reason=" + reason);

        return new PaymentDecision(score, action, reason);
    }
}
