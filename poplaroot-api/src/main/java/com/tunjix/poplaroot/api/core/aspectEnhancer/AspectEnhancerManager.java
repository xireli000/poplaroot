package com.tunjix.poplaroot.api.core.aspectEnhancer;
import com.tunjix.poplaroot.api.core.PlugDefinitionInfo;

import java.lang.reflect.Method;

/**
 * AUTHOR: XirALi · MaMat（西尔艾力·买买提）
 * DATE: 2024/8/12 15:28
 * 切面执行器
 */
public interface AspectEnhancerManager extends AspectEnhancerBaseManager{

    void methodBeforeInvoke(PlugDefinitionInfo target, Method method, Object[] args);


    void methodAfterInvoke(PlugDefinitionInfo target, Method method, Object returnValue, Throwable throwable);
}
