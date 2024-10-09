package com.tunjix.poplaroot.api.util;

import com.tunjix.poplaroot.api.annotations.Order;
import com.tunjix.poplaroot.api.annotations.Weight;
import com.tunjix.poplaroot.api.core.aspectEnhancer.AspectEnhancerManager;
import com.tunjix.poplaroot.common.util.CollectionUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

/**
 * AUTHOR: XirALi · MaMat（西尔艾力·买买提）
 * DATE: 2024/8/15 00:49
 */
final public class FactorySelectorUtil {

    private final Map<String, List<AspectEnhancerManager>> allAspectEnhancer;

    private FactorySelectorUtil(){
        allAspectEnhancer = new HashMap<>();
    }

    private static class SingletonHolder {
        private static final FactorySelectorUtil INSTANCE = new FactorySelectorUtil();
    }

    public static FactorySelectorUtil getInstance() {
        return FactorySelectorUtil.SingletonHolder.INSTANCE;
    }

    public void addAspectEnhancer(Class<?> key,Class<?> aspectEnhancer) throws InstantiationException, IllegalAccessException {
        String mapKey = key.getName();
        AspectEnhancerManager newInstance;
        try {
            newInstance = (AspectEnhancerManager) aspectEnhancer.getDeclaredConstructor().newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        if(allAspectEnhancer.containsKey(mapKey)){
            allAspectEnhancer.get(mapKey).add(newInstance);
        }else{
            allAspectEnhancer.put(mapKey,new ArrayList<AspectEnhancerManager>(){{add(newInstance);}});
        }
    }

    public List<AspectEnhancerManager> getAspectEnhancer(Class<?> key){
        return getAspectEnhancer(key.getName());
    }

    public List<AspectEnhancerManager> getAspectEnhancer(String className){
        return allAspectEnhancer.get(className);
    }

    public void sortAllAspectEnhancers() {
        if(CollectionUtils.isEmpty(allAspectEnhancer)){
            return;
        }else{
            for (Map.Entry<String, List<AspectEnhancerManager>> entry : allAspectEnhancer.entrySet()) {
                List<AspectEnhancerManager> enhancerList = entry.getValue();
                if (enhancerList.size() > 1) {
                    Collections.sort(enhancerList, new Comparator<AspectEnhancerManager>() {
                        @Override
                        public int compare(AspectEnhancerManager o1, AspectEnhancerManager o2) {
                            Weight dualPlugSPISettings = o1.getClass().getAnnotation(Weight.class);
                            Weight dualPlugSPISettings2 = o2.getClass().getAnnotation(Weight.class);
                            return Integer.compare(dualPlugSPISettings2==null?-1:dualPlugSPISettings2.value(), dualPlugSPISettings==null?-1:dualPlugSPISettings.value());
                        }
                    });
                }
            }
        }
    }
}
