package com.tunjix.poplaroot.api.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

/**
 * AUTHOR: XirAli · MaMat（西尔艾力·买买提）
 * DATE: 2024/7/22 01:16
 * 方法信息管理器
 */
public interface MethodInfo {

    String getMethodName();

    String getDeclaringClassName();

    Class<?> getReturnType();

    Type getGenericReturnType();

    Class<?>[] getParametersTypes();

    String getMethodDescriptor();

    Annotation[] getAnnotations();
}
