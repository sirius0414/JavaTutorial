package org.siyue.spring.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class LifecycleLoggingBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof PaymentService) {
            System.out.println("[BeforeInitialization BPP] postProcessBeforeInitialization -> " + beanName);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof PaymentService) {
            System.out.println("[AfterInitialization BPP] postProcessAfterInitialization -> " + beanName
                    + " (beanClass=" + bean.getClass().getName() + ")");
        }
        return bean;
    }
}
