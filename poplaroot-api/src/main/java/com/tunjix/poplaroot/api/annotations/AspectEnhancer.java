package com.tunjix.poplaroot.api.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * AUTHOR: XirALi · MaMat（西尔艾力·买买提）
 * DATE: 2024/8/15 00:02
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface AspectEnhancer {

    int order() default 0; // order 属性，默认值为 0

    Class<?>[] AspectClasses();//增强类

    boolean aspectAllMethod() default false;

//    String[] excludeMethods() default {};
//
//    String[] aspectMethods() default {};
}
