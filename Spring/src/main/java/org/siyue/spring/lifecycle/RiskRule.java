package org.siyue.spring.lifecycle;

public interface RiskRule {
    String name();

    int hitScore(PaymentRequest request);
}
