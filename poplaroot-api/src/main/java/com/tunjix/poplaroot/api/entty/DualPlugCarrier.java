package com.tunjix.poplaroot.api.entty;
import com.tunjix.poplaroot.api.core.PlugDefinitionInfo;

/**
 * AUTHOR: XirALi · MaMat（西尔艾力·买买提）
 * DATE: 2024/8/11 21:37
 */
public class DualPlugCarrier extends BaseDualPlugContext {

    private PlugDefinitionInfo plugDefinitionInfo;

    public DualPlugCarrier() {

    }

    public DualPlugCarrier(PlugDefinitionInfo plugDefinitionInfo) {
        this.plugDefinitionInfo = plugDefinitionInfo;
    }

    @Override
    public PlugDefinitionInfo getPlugDefinitionInfo() {
        return plugDefinitionInfo;
    }

    public void setPlugDefinitionInfo(PlugDefinitionInfo plugDefinitionInfo) {
        this.plugDefinitionInfo = plugDefinitionInfo;
    }
}
