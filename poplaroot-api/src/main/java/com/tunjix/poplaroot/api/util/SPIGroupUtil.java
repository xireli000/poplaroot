package com.tunjix.poplaroot.api.util;

import com.tunjix.poplaroot.api.annotations.Order;
import com.tunjix.poplaroot.api.core.*;
import com.tunjix.poplaroot.common.exceptions.NoAnnotationException;
import com.tunjix.poplaroot.common.exceptions.SceneConflictException;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

/**
 * AUTHOR: XirALi · MaMat（西尔艾力·买买提）
 * DATE: 2024/8/13 13:13
 */
final public class SPIGroupUtil {

    private final Map<String, SelectorManager> allFactorySelectorManager;

    private final Map<String, List<DualPlugAdviceManager>> allDualPlugAdviceManager;

    private final List<DualPlugRunPreProcessor> allDualPlugRunPreProcessorSPI;

    private final List<DualPlugRunPreProcessor> allDualPlugRunPreProcessor;

    private final List<DualPlugRunPostProcessor> allDualPlugRunPostProcessorSPI;

    private final List<DualPlugRunPostProcessor> allDualPlugRunPostProcessor;

    private final List<DualPlugScanConfigPostProcessor> allDualPlugScanConfigPostProcessorsSPI;

    private SPIGroupUtil() {
        allFactorySelectorManager = getAllFactorySelectorMap();
        allDualPlugAdviceManager = getAllDualPlugAdviceMap();
        allDualPlugRunPreProcessorSPI = getAllServiceLoader(DualPlugRunPreProcessor.class);
        allDualPlugRunPostProcessorSPI = getAllServiceLoader(DualPlugRunPostProcessor.class);
        allDualPlugRunPreProcessor = new ArrayList<>();
        allDualPlugRunPostProcessor = new ArrayList<>();
        allDualPlugScanConfigPostProcessorsSPI = getAllServiceLoader(DualPlugScanConfigPostProcessor.class);
    }

    private static class SingletonHolder {
        private static final SPIGroupUtil INSTANCE = new SPIGroupUtil();
    }

    public static SPIGroupUtil getInstance() {
        return SPIGroupUtil.SingletonHolder.INSTANCE;
    }


    private static <T> List<T> getAllServiceLoader(Class<T> clazz){
        ServiceLoader<T> managers = ServiceLoader.load(clazz);
        List<T> allManagers = new ArrayList<>(16);
        for (T manager : managers) {
            Order orderAnt = manager.getClass().getAnnotation(Order.class);
            if(orderAnt==null){
                throw new NoAnnotationException(manager.getClass().getName()+" This class cannot find the (com.tunjix.poplaroot.api.core.Order) annotation information");
            }
            allManagers.add(manager);
        }
        Collections.sort(allManagers, new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                Order dualPlugSPISettings = o1.getClass().getAnnotation(Order.class);
                Order dualPlugSPISettings2 = o2.getClass().getAnnotation(Order.class);
                return Integer.compare(dualPlugSPISettings.value(), dualPlugSPISettings2.value());
            }
        });
        return allManagers;
    }

    private static Map<String, SelectorManager> getAllFactorySelectorMap(){
        List<SelectorManager> allManagers = getAllServiceLoader(SelectorManager.class);
        Map<String, SelectorManager> factorySelectorManagerMap = new LinkedHashMap<>(allManagers.size());
        for (SelectorManager item : allManagers) {
            ClassifiedSPIScenario<?> scenarioEnum = item.getScenario();
            if(scenarioEnum==null){
                throw new NullPointerException(item.getClass().getName()+" This getScenario method returns null");
            }
            String key = scenarioEnum.name();
            if(factorySelectorManagerMap.containsKey(key)){
                throw new SceneConflictException(item.getClass().getName()+" The scenario for this implementation class already exists.Look at the getScenario method");
            }
            factorySelectorManagerMap.put(key,item);
        }
        return factorySelectorManagerMap;
    }

    private static Map<String, List<DualPlugAdviceManager>> getAllDualPlugAdviceMap(){
        List<DualPlugAdviceManager> allManagers = getAllServiceLoader(DualPlugAdviceManager.class);
        Map<String,List<DualPlugAdviceManager>> dualPlugAdviceMap = new HashMap<>(16);
        for (DualPlugAdviceManager item : allManagers) {
            ClassifiedSPIScenario<?> scenarioEnum = item.getScenario();
            if(scenarioEnum==null){
                throw new NullPointerException(item.getClass().getName()+" This getScenario method returns null");
            }
            String key = scenarioEnum.name();
            if(dualPlugAdviceMap.containsKey(key)){
                dualPlugAdviceMap.get(key).add(item);
            }else {
                List<DualPlugAdviceManager> dualPlugAdviceManagers = new ArrayList<DualPlugAdviceManager>(16){{add(item);}};
                dualPlugAdviceMap.put(key,dualPlugAdviceManagers);
            }
        }
        return dualPlugAdviceMap;
    }

    public Map<String, SelectorManager> getAllFactorySelectorManager() {
        return allFactorySelectorManager;
    }

    public Map<String, List<DualPlugAdviceManager>> getAllDualPlugAdviceManager() {
        return allDualPlugAdviceManager;
    }

    public List<DualPlugRunPreProcessor> getAllDualPlugRunPreProcessorSPI() {
        return allDualPlugRunPreProcessorSPI;
    }

    public List<DualPlugRunPreProcessor> getAllDualPlugRunPreProcessor() {
        return allDualPlugRunPreProcessor;
    }

    public boolean registerDualPlugRunPreProcessor(Class<?> item) {
        DualPlugRunPreProcessor obj;
        try {
            obj= (DualPlugRunPreProcessor) item.getDeclaredConstructor().newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        return allDualPlugRunPreProcessor.add(obj);
    }

    public List<DualPlugRunPostProcessor> getAllDualPlugRunPostProcessorSPI() {
        return allDualPlugRunPostProcessorSPI;
    }

    public List<DualPlugRunPostProcessor> getAllDualPlugRunPostProcessor() {
        return allDualPlugRunPostProcessor;
    }

    public boolean registerDualPlugRunPostProcessor(Class<?> item) {
        DualPlugRunPostProcessor obj;
        try {
            obj= (DualPlugRunPostProcessor) item.getDeclaredConstructor().newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        return allDualPlugRunPostProcessor.add(obj);
    }

    public List<DualPlugScanConfigPostProcessor> getAllDualPlugScanConfigPostProcessorsSPI() {
        return allDualPlugScanConfigPostProcessorsSPI;
    }
}
