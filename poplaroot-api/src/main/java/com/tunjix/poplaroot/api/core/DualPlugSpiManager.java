package com.tunjix.poplaroot.api.core;

import com.tunjix.poplaroot.api.util.SPIGroupUtil;

import java.util.List;
import java.util.Map;

/**
 * AUTHOR: XirALi · MaMat（西尔艾力·买买提）
 * DATE: 2024/8/13 16:35
 * Spi 管理器
 */
public interface DualPlugSpiManager {

    default Map<String, SelectorManager> getAllFactorySelectorManager() {
        return SPIGroupUtil.getInstance().getAllFactorySelectorManager();
    }

    default Map<String, List<DualPlugAdviceManager>> getAllDualPlugAdviceManager() {
        return SPIGroupUtil.getInstance().getAllDualPlugAdviceManager();
    }
}
