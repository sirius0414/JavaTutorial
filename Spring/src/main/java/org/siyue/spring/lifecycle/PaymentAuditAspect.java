package org.siyue.spring.lifecycle;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PaymentAuditAspect {

    @Around("execution(* org.siyue.spring.lifecycle.PaymentService.pay(..))")
    public Object aroundPay(ProceedingJoinPoint joinPoint) throws Throwable {
        long begin = System.currentTimeMillis();
        System.out.println("[AOP Proxy] risk audit start -> " + joinPoint.getSignature().toShortString());
        try {
            return joinPoint.proceed();
        } finally {
            System.out.println("[AOP Proxy] risk audit finished in " + (System.currentTimeMillis() - begin) + " ms");
        }
    }
}
