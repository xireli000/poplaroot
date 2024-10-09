package com.tunjix.poplaroot.api.core;

import com.tunjix.poplaroot.api.util.AdviceContextThread;

/**
 * AUTHOR: XirALi · MaMat（西尔艾力·买买提）
 * DATE: 2024/8/11 21:27
 * Thread local 管理器
 */
public interface AdviceContextManager {

    default String setContext(Object obj) {
        return AdviceContextThread.setContext(obj);
    }

    default Object getContext(String key) {
        return AdviceContextThread.getContext(key);
    }

    default void clearContext(String key) {
        AdviceContextThread.clearContext(key);
    }

    default void clearAllContext() {
        AdviceContextThread.clearAllContext();
    }
}
