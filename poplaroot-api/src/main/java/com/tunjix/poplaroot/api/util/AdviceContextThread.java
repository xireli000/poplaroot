package com.tunjix.poplaroot.api.util;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * AUTHOR: XirALi · MaMat（西尔艾力·买买提）
 * DATE: 2024/8/11 21:18
 */
final public class AdviceContextThread {

    private static final ThreadLocal<Map<String, Object>> threadLocalContext = ThreadLocal.withInitial(HashMap::new);

    public static String setContext(Object obj) {
        String key = UUID.randomUUID().toString();
        threadLocalContext.get().put(key, obj);
        return key;
    }

    public static Object getContext(String key) {
        return threadLocalContext.get().get(key);
    }

    public static void clearContext(String key) {
        threadLocalContext.get().remove(key);
    }

    public static void clearAllContext() {
        threadLocalContext.remove();
    }
}
