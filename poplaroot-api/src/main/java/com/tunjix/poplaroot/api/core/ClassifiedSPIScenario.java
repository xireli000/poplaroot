package com.tunjix.poplaroot.api.core;

/**
 * AUTHOR: XirALi · MaMat（西尔艾力·买买提）
 * DATE: 2024/8/13 12:26
 * 分类注册器
 */
public interface ClassifiedSPIScenario<T> {

    T getScenario();

    String name();
}
