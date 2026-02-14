package org.siyue.spring.lifecycle;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class PaymentService implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean {

    @Override
    public void setBeanName(String name) {
        System.out.println("[Aware] BeanNameAware#setBeanName -> " + name);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("[Aware] BeanFactoryAware#setBeanFactory -> " + beanFactory.getClass().getSimpleName());
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("[Aware] ApplicationContextAware#setApplicationContext -> " + applicationContext.getClass().getSimpleName());
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("[BeforeInitialization BPP phase] @PostConstruct executed");
    }

    @Override
    public void afterPropertiesSet() {
        System.out.println("[invokeInitMethods] InitializingBean#afterPropertiesSet executed");
    }

    public void customInitMethod() {
        System.out.println("[invokeInitMethods] init-method(customInitMethod) executed");
    }

    public void pay(String orderNo) {
        System.out.println("[Business] PaymentService.pay -> processing " + orderNo);
    }
}
