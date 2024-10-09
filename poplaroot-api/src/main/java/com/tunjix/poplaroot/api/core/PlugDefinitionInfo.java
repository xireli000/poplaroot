package com.tunjix.poplaroot.api.core;
import java.util.Set;

/**
 * AUTHOR: XirAli · MaMat（西尔艾力·买买提）
 * DATE: 2024/7/22 01:53
 * dualPlug定义
 */
public interface PlugDefinitionInfo {

    String getClassName();

    Class<?> getSuperClass();

    Set<Class<?>> getInterfaces();

    Set<MethodInfo> getDeclaredMethods();

    Class<?> getClassObj();
}
