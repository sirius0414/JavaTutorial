# Spring Bean 生命周期（initializeBean）工程化 Demo

本示例对应笔记 `SpringPrinciple.md` 中的 **1.1.3.6 实例化阶段 / initializeBean()**，演示如下顺序：

1. **Aware**
2. **BeforeInitialization BeanPostProcessor**
   - `@PostConstruct` 在这一阶段执行
3. **invokeInitMethods**
   - `afterPropertiesSet`
   - `init-method`
4. **AfterInitialization BeanPostProcessor**
   - AOP 在这里创建代理（返回代理对象）

## 目录

- `LifecycleConfig`：`@Bean(initMethod = "customInitMethod")`
- `PaymentService`：实现 `BeanNameAware` / `BeanFactoryAware` / `ApplicationContextAware` / `InitializingBean`，并包含 `@PostConstruct`
- `LifecycleLoggingBeanPostProcessor`：打印 before/after 初始化阶段
- `PaymentAuditAspect`：AOP 切面，验证代理生效
- `SpringLifecycleDemoApplication`：启动后通过 `CommandLineRunner` 调用业务方法

## 运行

```bash
cd Spring
./mvnw spring-boot:run
```

## 预期日志（关键片段）

```text
[Aware] BeanNameAware#setBeanName -> paymentService
[Aware] BeanFactoryAware#setBeanFactory -> DefaultListableBeanFactory
[Aware] ApplicationContextAware#setApplicationContext -> AnnotationConfigApplicationContext

[BeforeInitialization BPP] postProcessBeforeInitialization -> paymentService
[BeforeInitialization BPP phase] @PostConstruct executed

[invokeInitMethods] InitializingBean#afterPropertiesSet executed
[invokeInitMethods] init-method(customInitMethod) executed

[AfterInitialization BPP] postProcessAfterInitialization -> paymentService (beanClass=...PaymentService$$SpringCGLIB$$...)

[AOP Proxy] before method -> PaymentService.pay(..)
[Business] PaymentService.pay -> processing order-20260214
[AOP Proxy] after method -> PaymentService.pay(..)
```

> 说明：实际顺序中，`@PostConstruct` 由 `CommonAnnotationBeanPostProcessor` 在 before-initialization 阶段触发。
