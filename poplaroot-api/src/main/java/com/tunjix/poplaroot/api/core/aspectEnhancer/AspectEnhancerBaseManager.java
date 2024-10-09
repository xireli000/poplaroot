package com.tunjix.poplaroot.api.core.aspectEnhancer;
import com.tunjix.poplaroot.api.core.DualPlugContext;
import com.tunjix.poplaroot.api.core.MethodInfo;
import com.tunjix.poplaroot.api.core.PlugDefinitionInfo;
import com.tunjix.poplaroot.api.entty.CircuitBreakerInfo;
import com.tunjix.poplaroot.api.util.DualPlugMethodUtil;

/**
 * AUTHOR: XirALi · MaMat（西尔艾力·买买提）
 * DATE: 2024/8/12 15:28
 * 切面执行器
 */
public interface AspectEnhancerBaseManager {

    default CircuitBreakerInfo aspectCircuitBreaker(Object[] args, String methodName, String methodDescriptor, boolean isVoid, PlugDefinitionInfo target){
        return new CircuitBreakerInfo(true);
    }

    default MethodInfo getMethodInfo(PlugDefinitionInfo target, String methodName, String methodDescriptor){
        return DualPlugMethodUtil.getMethod(target, methodName, methodDescriptor);
    }
}
