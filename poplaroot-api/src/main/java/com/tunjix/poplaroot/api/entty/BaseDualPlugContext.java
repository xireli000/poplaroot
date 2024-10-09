package com.tunjix.poplaroot.api.entty;

import com.tunjix.poplaroot.api.adapter.DualPlugContextAdapter;
import com.tunjix.poplaroot.api.core.DualPlugScanConfig;
import com.tunjix.poplaroot.api.core.MethodInfo;
import com.tunjix.poplaroot.api.core.PlugDefinitionInfo;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * AUTHOR: XirALi · MaMat（西尔艾力·买买提）
 * DATE: 2024/8/13 16:49
 */
public class BaseDualPlugContext extends DualPlugContextAdapter {

    private String id;
    private String sceneKey;

    private Map<String, Collection<MethodInfo>> methodDispatcher = new HashMap<>();

    @Override
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getSceneKey() {
        return sceneKey;
    }

    public void setSceneKey(String sceneKey) {
        this.sceneKey = sceneKey;
    }

    @Override
    public PlugDefinitionInfo getPlugDefinitionInfo() {
        return null;
    }

    public Collection<MethodInfo> getMethodsByScene(String sceneKey) {
        return methodDispatcher.get(sceneKey);
    }

    public void addMethodsByScene(String sceneKey , Collection<MethodInfo> methodDispatchers) {
        this.methodDispatcher.put(sceneKey,methodDispatchers);
    }
}
