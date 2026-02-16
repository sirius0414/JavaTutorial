package org.siyue.spring.lifecycle;

import java.util.List;

public interface RiskRuleProvider {
    List<RiskRule> provideRules();
}
