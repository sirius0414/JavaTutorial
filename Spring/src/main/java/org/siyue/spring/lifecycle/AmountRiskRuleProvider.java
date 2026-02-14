package org.siyue.spring.lifecycle;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AmountRiskRuleProvider implements RiskRuleProvider {

    @Override
    public List<RiskRule> provideRules() {
        return List.of(
                new RiskRule() {
                    @Override
                    public String name() {
                        return "large-amount";
                    }

                    @Override
                    public int hitScore(PaymentRequest request) {
                        return request.amount() >= 5_000 ? 35 : 0;
                    }
                },
                new RiskRule() {
                    @Override
                    public String name() {
                        return "very-large-amount";
                    }

                    @Override
                    public int hitScore(PaymentRequest request) {
                        return request.amount() >= 10_000 ? 30 : 0;
                    }
                }
        );
    }
}
