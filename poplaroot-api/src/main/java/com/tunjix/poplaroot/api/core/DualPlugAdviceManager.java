package com.tunjix.poplaroot.api.core;

import com.tunjix.poplaroot.api.entty.CircuitBreakerInfo;
import com.tunjix.poplaroot.api.util.DualPlugMethodUtil;

import java.lang.reflect.Method;

/**
 * AUTHOR: XirALi · MaMat（西尔艾力·买买提）
 * DATE: 2024/8/12 15:28
 * 增强完后的执行器管理中心
 */
public interface DualPlugAdviceManager extends DualPlugSPISettings{

    default void methodBeforeInvoke(DualPlugContext context, Method method, Object[] args){}

    default CircuitBreakerInfo circuitBreakerInvoke(Object[] args, String methodName, String methodDescriptor, boolean isVoid, DualPlugContext context){
        CircuitBreakerInfo circuitBreakerInfo = circuitBreaker(args, methodName, methodDescriptor, isVoid, context);
        if(circuitBreakerInfo==null){
            throw new RuntimeException(context.getPlugDefinitionInfo().getClassName()+"#"+methodName+" The target class blocker cannot be empty");
        }
        if(!circuitBreakerInfo.getSuccess()&&(!isVoid)){
            MethodInfo method = DualPlugMethodUtil.getMethod(context, methodName, methodDescriptor);
            Object returnValue = circuitBreakerInfo.getReturnValue();
            boolean javaBaseType = isJavaBaseType(method.getReturnType());
            if(returnValue==null){
                if(javaBaseType){
                    circuitBreakerInfo.setReturnValue(getDefaultValue(method.getReturnType()));
                }
            }else{
                Class<?> returnClass = returnValue.getClass();
                if(javaBaseType){
                    Class<?> aClass = DualPlugMethodUtil.PRIMITIVE_TO_WRAPPER.get(method.getReturnType());
                    if(!returnClass.equals(aClass)){
                        if(!returnClass.equals(method.getReturnType())){
                            throw new ClassCastException(method.getDeclaringClassName()+" The class return type of the target class method is "+method.getReturnType().getName()+", and the actual return value is "+returnClass.getName()+", which cannot be cast");
                        }
                    }
                }
            }
        }
        return circuitBreakerInfo;
    }

    default CircuitBreakerInfo circuitBreaker(Object[] args, String methodName, String methodDescriptor, boolean isVoid, DualPlugContext context){
        return new CircuitBreakerInfo(true);
    }

    default void methodAfterInvoke(DualPlugContext context, Method method, Object returnValue, Throwable throwable){}

    default Object getDefaultValue(Class<?> returnClass){
        if(returnClass.equals(boolean.class)){
            return false;
        }else if(returnClass.equals(char.class)){
            return ' ';
        }else if(returnClass.equals(byte.class)){
            return 0;
        }else if(returnClass.equals(short.class)){
            return 0;
        }else if(returnClass.equals(int.class)){
            return 0;
        }else if(returnClass.equals(float.class)){
            return 0.0F;
        }else if(returnClass.equals(long.class)){
            return 0L;
        }else if(returnClass.equals(double.class)){
            return 0.0D;
        }else{
            return null;
        }
    }

    default boolean isJavaBaseType(Class<?> returnClass){
        return returnClass.equals(boolean.class)
                || returnClass.equals(char.class) || returnClass.equals(byte.class)
                || returnClass.equals(short.class) || returnClass.equals(int.class)
                || returnClass.equals(float.class) || returnClass.equals(long.class)
                || returnClass.equals(double.class);
    }
}
