package com.tunjix.poplaroot.api.util;

import com.tunjix.poplaroot.api.core.PlugDefinitionInfo;

import java.util.HashMap;
import java.util.Map;

/**
 * AUTHOR: XirALi · MaMat（西尔艾力·买买提）
 * DATE: 2024/8/13 13:13
 */
final public class DualPlugScannerUtil {

    private final Map<String, PlugDefinitionInfo> allPlugDefinitionInfo;

    private DualPlugScannerUtil() {
        allPlugDefinitionInfo = new HashMap<>(128);
    }

    private static class SingletonHolder {
        private static final DualPlugScannerUtil INSTANCE = new DualPlugScannerUtil();
    }

    public static DualPlugScannerUtil getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public PlugDefinitionInfo getPlugDefinitionInfo(String key) {
        return allPlugDefinitionInfo.get(key);
    }

    public void putPlugDefinitionInfo(String key,PlugDefinitionInfo plugDefinitionInfo) {
        allPlugDefinitionInfo.put(key,plugDefinitionInfo);
    }

    public boolean containsPlugDefinitionInfo(String key) {
        return allPlugDefinitionInfo.containsKey(key);
    }
}
