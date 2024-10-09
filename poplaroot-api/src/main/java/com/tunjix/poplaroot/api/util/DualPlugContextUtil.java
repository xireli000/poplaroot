package com.tunjix.poplaroot.api.util;
import com.tunjix.poplaroot.api.core.DualPlugContext;
import com.tunjix.poplaroot.common.util.CollectionUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * AUTHOR: XirALi · MaMat（西尔艾力·买买提）
 * DATE: 2024/8/14 00:59
 */
final public class DualPlugContextUtil {

    private final Map<String, DualPlugContext> allDualPlugContextById;

    private final Map<String,Map<String, String>> allDualPlugContextByClassNameAndScene;

    private DualPlugContextUtil() {
        allDualPlugContextById = new HashMap<>(128);
        allDualPlugContextByClassNameAndScene = new HashMap<>(16);
    }

    private static class SingletonHolder {
        private static final DualPlugContextUtil INSTANCE = new DualPlugContextUtil();
    }

    public static DualPlugContextUtil getInstance() {
        return DualPlugContextUtil.SingletonHolder.INSTANCE;
    }

    public DualPlugContext getDualPlugContextById(String key) {
        return allDualPlugContextById.get(key);
    }

    public DualPlugContext getDualPlugContextByClassName(String scene, String key) {
        Map<String, String> map = allDualPlugContextByClassNameAndScene.get(scene);
        if(CollectionUtils.isEmpty(map)){
            return null;
        }else{
            String contextId = map.get(key);
            if(contextId!=null){
                return getDualPlugContextById(contextId);
            }else{
                return null;
            }
        }
    }

    public String addDualPlugContext(DualPlugContext dualPlugContext) {
        String key = UUID.randomUUID().toString();
        allDualPlugContextById.put(key,dualPlugContext);
        String className = dualPlugContext.getPlugDefinitionInfo().getClassName();
        String scene = dualPlugContext.getSceneKey();
        Map<String, String> stringStringMap = allDualPlugContextByClassNameAndScene.get(scene);
        if(CollectionUtils.isEmpty(stringStringMap)){
            allDualPlugContextByClassNameAndScene.put(scene,new HashMap<String,String>(128){{put(className,key);}});
        }else{
            stringStringMap.put(className,key);
        }
        return key;
    }
}
