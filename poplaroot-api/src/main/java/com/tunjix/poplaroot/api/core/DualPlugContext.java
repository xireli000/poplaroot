package com.tunjix.poplaroot.api.core;

import java.util.Collection;

/**
 * AUTHOR: XirALi · MaMat（西尔艾力·买买提）
 * DATE: 2024/8/11 21:52
 * DualPlug 上下文
 */
public interface DualPlugContext {

    PlugDefinitionInfo getPlugDefinitionInfo();

    String getSceneKey();

    String getId();

    Collection<MethodInfo> getMethodsByScene(String sceneKey);

    void addMethodsByScene(String sceneKey , Collection<MethodInfo> methodDispatchers);
}
