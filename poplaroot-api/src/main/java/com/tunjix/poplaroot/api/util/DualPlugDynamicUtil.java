package com.tunjix.poplaroot.api.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * AUTHOR: XirALi · MaMat（西尔艾力·买买提）
 * DATE: 2024/8/13 13:13
 */
final public class DualPlugDynamicUtil {

    private final Map<String, byte[]> allPlugDefinitionInfo;

    private final AtomicBoolean flag =new AtomicBoolean(true);

    private DualPlugDynamicUtil() {
        allPlugDefinitionInfo = new HashMap<>(128);
    }

    private static class SingletonHolder {
        private static final DualPlugDynamicUtil INSTANCE = new DualPlugDynamicUtil();
    }

    public static DualPlugDynamicUtil getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public byte[] getClassByteInfo(Class<?> clazz) {
        byte[] bytes = allPlugDefinitionInfo.get(clazz.getName());
        if(bytes==null&&flag.get()){
            try {
                return ClassDynamicUtil.getModifiedBytecode(clazz);
            } catch (IOException e) {
                throw new RuntimeException(clazz.getName()+"Analytic exception",e);
            }
        }else{
            return bytes;
        }
    }

    public void addClassByteInfo(Class<?> clazz, byte[] classInfo){
        if(flag.get()){
            allPlugDefinitionInfo.put(clazz.getName(),classInfo);
        }
    }

    public void clear(){
        allPlugDefinitionInfo.clear();
        flag.set(false);
    }
}
