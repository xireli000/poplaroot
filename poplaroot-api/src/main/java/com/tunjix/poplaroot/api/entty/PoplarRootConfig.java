package com.tunjix.poplaroot.api.entty;

/**
 * AUTHOR: XirALi · MaMat（西尔艾力·买买提）
 * DATE: 2024/9/23 10:55
 */
public class PoplarRootConfig {

    private Class<?> mainClass;

    private boolean isSpring = false;

    public Class<?> getMainClass() {
        return mainClass;
    }

    public void setMainClass(Class<?> mainClass) {
        this.mainClass = mainClass;
    }

    public boolean isSpring() {
        return isSpring;
    }

    public void setSpring(boolean spring) {
        isSpring = spring;
    }



    private static class SingletonHolder {
        private static final PoplarRootConfig INSTANCE = new PoplarRootConfig();
    }

    public static PoplarRootConfig getInstance() {
        return PoplarRootConfig.SingletonHolder.INSTANCE;
    }
}
