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
        System.out.println("[AOP Proxy] before method -> " + joinPoint.getSignature().toShortString());
        Object result = joinPoint.proceed();
        System.out.println("[AOP Proxy] after method -> " + joinPoint.getSignature().toShortString());
        return result;
    }
}
