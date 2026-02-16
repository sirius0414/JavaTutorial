# Spring Bean 生命周期（initializeBean）业务化 Demo

本示例不再只是“打印生命周期”，而是做了一个**支付风控服务**场景：

- 输入：订单号、商户、IP、金额
- 输出：风控分数 + 处理动作（PASS / MANUAL_REVIEW）
- 规则来源：多个 `RiskRuleProvider` Bean 聚合

并把 `initializeBean()` 的 4 段落在实际业务里：

---

## 1) Aware

`PaymentService` 实现：

- `BeanNameAware`
- `BeanFactoryAware`
- `ApplicationContextAware`

业务价值：
- 获取 Bean 名用于统一审计日志标识
- 拿到 `ApplicationContext`，后续在 `afterPropertiesSet` 聚合所有规则提供器 Bean

---

## 2) BeforeInitialization BPP（`@PostConstruct` 在此阶段）

- `LifecycleLoggingBeanPostProcessor#postProcessBeforeInitialization`
  - 统一注入“人工审核阈值”策略（`manualReviewThreshold=85`）
- `PaymentService#prepareEmergencyData` (`@PostConstruct`)
  - 加载应急黑名单 IP
  - 加载商户基础风险画像

业务价值：
- 在 Bean 正式初始化前，注入策略和兜底数据，防止服务启动后“空规则运行”

---

## 3) invokeInitMethods

- `afterPropertiesSet`
  - 从容器中聚合全部 `RiskRuleProvider`，形成统一规则集
  - 若规则为空则 fail-fast
- `init-method = warmUpRiskCache`
  - 进行风险缓存/模型预热（示例为基础风险缓存预热）

业务价值：
- 把“可用性校验 + 预热”放在初始化末端，确保对外服务前已 ready

---

## 4) AfterInitialization BPP（AOP 在此生成代理）

- `LifecycleLoggingBeanPostProcessor#postProcessAfterInitialization`
  - 检查 `paymentService` 是否已被 AOP 代理
- `PaymentAuditAspect`
  - 拦截 `PaymentService.pay(..)` 做耗时审计日志

业务价值：
- 代理在 after-initialization 阶段形成，业务方法天然获得横切能力（审计、限流、重试等）

---

## 运行

```bash
cd Spring
./mvnw spring-boot:run
```

## 关键类

- `PaymentService`：核心业务 Bean（完整生命周期演示）
- `RiskRuleProvider` + `AmountRiskRuleProvider` + `IpRiskRuleProvider`：规则扩展点
- `LifecycleLoggingBeanPostProcessor`：before/after 初始化业务注入与校验
- `PaymentAuditAspect`：AOP 审计
- `SpringLifecycleDemoApplication`：启动后触发三笔风控判定
