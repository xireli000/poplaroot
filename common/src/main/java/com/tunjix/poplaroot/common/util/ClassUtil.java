package com.tunjix.poplaroot.common.util;

import java.util.HashSet;
import java.util.Set;

/**
 * AUTHOR: XirALi · MaMat（西尔艾力·买买提）
 * DATE: 2024/8/7 16:31
 */
public class ClassUtil {

    public static Set<Class<?>> getAllInterfaces(Class<?> clazz) {
        Set<Class<?>> interfaces = new HashSet<>(16);
        while (clazz != null) {
            for (Class<?> iface : clazz.getInterfaces()) {
                interfaces.add(iface);
                interfaces.addAll(getAllInterfaces(iface));
            }
            clazz = clazz.getSuperclass();
        }
        return interfaces;
    }
}
