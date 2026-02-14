package org.siyue.spring.lifecycle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LifecycleConfig {

    @Bean(initMethod = "customInitMethod")
    public PaymentService paymentService() {
        return new PaymentService();
    }
}
