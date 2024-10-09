package com.tunjix.poplaroot.api.enums;

import com.tunjix.poplaroot.api.core.ClassifiedSPIScenario;

/**
 * AUTHOR: XirALi · MaMat（西尔艾力·买买提）
 * DATE: 2024/8/13 12:31
 */
public enum ClassifiedSPIScenarioEnum implements ClassifiedSPIScenario<ClassifiedSPIScenarioEnum> {

    Default_Scenario("Default_Scenario"),
    Processor_Scenario("Processor_Scenario"),
    AOP_Scenario("AOP_Scenario");

    private final String key;

    ClassifiedSPIScenarioEnum(String key) {
        this.key = key;
    }

    @Override
    public ClassifiedSPIScenarioEnum getScenario() {
        return ClassifiedSPIScenarioEnum.Default_Scenario;
    }

    public String getKey() {
        return key;
    }
}
