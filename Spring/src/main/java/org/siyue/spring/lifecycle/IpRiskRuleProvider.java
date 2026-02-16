package org.siyue.spring.lifecycle;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
public class IpRiskRuleProvider implements RiskRuleProvider {

    private static final Set<String> HIGH_RISK_IP_SEGMENT = Set.of("10.13", "172.19");

    @Override
    public List<RiskRule> provideRules() {
        return List.of(new RiskRule() {
            @Override
            public String name() {
                return "suspicious-ip-segment";
            }

            @Override
            public int hitScore(PaymentRequest request) {
                return HIGH_RISK_IP_SEGMENT.stream().anyMatch(request.clientIp()::startsWith) ? 40 : 0;
            }
        });
    }
}
