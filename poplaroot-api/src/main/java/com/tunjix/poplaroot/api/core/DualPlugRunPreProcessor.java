package com.tunjix.poplaroot.api.core;

/**
 * AUTHOR: XirALi · MaMat（西尔艾力·买买提）
 * DATE: 2024/8/30 12:28
 */
public interface DualPlugRunPreProcessor {

    void runPreProcessor();

    default void reinforceScanConfig(DualPlugScanConfig dualPlugScanConfig){

    }
}
