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
            System.out.println("\n========= Trigger business method to verify AOP proxy =========");
            paymentService.pay("order-20260214");
            System.out.println("===============================================================\n");
        };
    }
}
