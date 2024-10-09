package com.tunjix.poplaroot.api.core;

/**
 * AUTHOR: XirALi · MaMat（西尔艾力·买买提）
 * DATE: 2024/8/11 02:04
 * 分类工厂中心
 */
public interface SelectorManager extends DualPlugSPISettings{

    void selectorInvoke(DualPlugContext dualPlugContext);

    void invoke(DualPlugContext dualPlugContext);
}
