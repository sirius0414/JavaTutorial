package org.siyue.spring.lifecycle;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class SpringLifecycleDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringLifecycleDemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner lifecycleRunner(PaymentService paymentService) {
        return args -> {
            System.out.println("\n========= trigger payment risk-check business =========");

            paymentService.pay(new PaymentRequest("order-001", "m-video", "10.13.4.8", 3200));
            paymentService.pay(new PaymentRequest("order-002", "m-oversea", "8.8.8.8", 12000));
            paymentService.pay(new PaymentRequest("order-003", "m-digital", "43.99.0.1", 200));

            System.out.println("========================================================\n");
        };
    }
}
