package com.tunjix.poplaroot.api.adapter;

import com.tunjix.poplaroot.api.core.ClassificationAndProcessingManager;
import com.tunjix.poplaroot.api.core.DualPlugScanConfig;
import com.tunjix.poplaroot.api.core.DualPlugSpiManager;
import com.tunjix.poplaroot.api.util.DualPlugDynamicUtil;

/**
 * AUTHOR: XirALi · MaMat（西尔艾力·买买提）
 * DATE: 2024/8/7 21:43
 */
public abstract class ClassificationAndProcessingAdapter implements ClassificationAndProcessingManager, DualPlugSpiManager {

    @Override
    public void invoke(DualPlugScanConfig dualPlugScanConfig) {
        executionPlugFactory(dualPlugScanConfig);
        clearInstanceByteData();
    }

    protected abstract void executionPlugFactory(DualPlugScanConfig dualPlugScanConfig);

    private void clearInstanceByteData(){
        DualPlugDynamicUtil.getInstance().clear();
    }
}
