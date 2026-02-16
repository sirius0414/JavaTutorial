package org.siyue.spring.lifecycle;

public record PaymentRequest(String orderNo, String merchantId, String clientIp, int amount) {
}
