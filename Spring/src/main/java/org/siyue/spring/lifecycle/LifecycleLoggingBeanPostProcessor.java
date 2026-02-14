package org.siyue.spring.lifecycle;

import org.springframework.aop.support.AopUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class LifecycleLoggingBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof PaymentService paymentService) {
            // 业务意义：统一在这里注入“人工审核阈值策略”（可由环境动态切换）
            paymentService.setManualReviewThreshold(85);
            System.out.println("[BeforeInitialization BPP] set manualReviewThreshold=85 for " + beanName);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (beanName.equals("paymentService")) {
            boolean proxied = AopUtils.isAopProxy(bean);
            System.out.println("[AfterInitialization BPP] " + beanName + " proxiedByAop=" + proxied
                    + " beanClass=" + bean.getClass().getName());
        }
        return bean;
    }
}
