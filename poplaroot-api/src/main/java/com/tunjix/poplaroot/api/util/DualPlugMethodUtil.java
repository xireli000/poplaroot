package com.tunjix.poplaroot.api.util;

import com.tunjix.poplaroot.api.core.DualPlugContext;
import com.tunjix.poplaroot.api.core.MethodInfo;
import com.tunjix.poplaroot.api.core.PlugDefinitionInfo;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * AUTHOR: XirALi · MaMat（西尔艾力·买买提）
 * DATE: 2024/8/27 11:04
 */
final public class DualPlugMethodUtil {

    public final static Map<Class<?>, Class<?>> PRIMITIVE_TO_WRAPPER = new HashMap<Class<?>, Class<?>>(){{
        put(boolean.class, Boolean.class);
        put(char.class, Character.class);
        put(byte.class, Byte.class);
        put(short.class, Short.class);
        put(int.class, Integer.class);
        put(float.class, Float.class);
        put(long.class, Long.class);
        put(double.class, Double.class);
    }};

    public static MethodInfo getMethod(DualPlugContext context, String methodName, String methodDescriptor){
        Collection<MethodInfo> methodsByScene = context.getMethodsByScene(context.getSceneKey());
        for (MethodInfo methodInfo : methodsByScene) {
            if(methodInfo.getMethodName().equals(methodName)&&methodInfo.getMethodDescriptor().equals(methodDescriptor)){
                return methodInfo;
            }
        }
        throw new RuntimeException(context.getPlugDefinitionInfo().getClassName()+" This class cannot find the method to be enhanced. "+methodName);
    }

    public static MethodInfo getMethod(PlugDefinitionInfo target, String methodName, String methodDescriptor){
        Collection<MethodInfo> methodsByScene = target.getDeclaredMethods();
        for (MethodInfo methodInfo : methodsByScene) {
            if(methodInfo.getMethodName().equals(methodName)&&methodInfo.getMethodDescriptor().equals(methodDescriptor)){
                return methodInfo;
            }
        }
        return null;
    }
}
