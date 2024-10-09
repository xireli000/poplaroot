package com.tunjix.poplaroot.api.core;

import java.util.List;

/**
 * AUTHOR: XirALi · MaMat（西尔艾力·买买提）
 * DATE: 2024/8/7 14:55
 * DualPlug扫描配置中心
 */
public interface DualPlugScanConfig {
    /**
     * 扫描路径
     * @return
     */
    String[] getScanBasePackages();
    /**
     * 设置扫描路径
     * @return
     */
    void setScanBasePackages(String[] scanBasePackages);
    /**
     * 扫描Classes
     * @return
     */
    Class<?>[] getScanClasses();

    /**
     * 设置扫描Classes
     * @param scanClasses
     */
    void setScanClasses(Class<?>[] scanClasses);
    /**
     * 排出Classes
     * @return
     */
    Class<?>[] getExcludeClasses();
    /**
     * 设置排出Classes
     * @return
     */
    void setExcludeClasses(Class<?>[] excludeClasses);
    /**
     * 排出路径
     * @return
     */
    List<String> getExcludePackages();

    void setExcludePackages(List<String> excludePackages);

    default <T> T[] arraycopy(T[] array1, T[] array2){
        T[] mergedArray = (T[]) new Object[array1.length + array2.length];
        System.arraycopy(array1, 0, mergedArray, 0, array1.length);
        System.arraycopy(array2, 0, mergedArray, array1.length, array2.length);
        return mergedArray;
    }

    default <T> T[] addElement(T[] originalArray, T newElement){
        T[] newArray = (T[]) new Object[originalArray.length + 1];
        System.arraycopy(originalArray, 0, newArray, 0, originalArray.length);
        newArray[newArray.length - 1] = newElement;
        return newArray;
    }
}
