package com.tunjix.poplaroot.api.core.proxy;

/**
 * AUTHOR: XirALi · MaMat（西尔艾力·买买提）
 * DATE: 2024/8/29 12:10
 */
public interface DualPlugProxyInfo<T> {

    T getProxy();

    Class<T> getTargetClass();
}
