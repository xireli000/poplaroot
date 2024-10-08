package com.tunjix.poplaroot.common.exceptions;

/**
 * AUTHOR: XirALi · MaMat（西尔艾力·买买提）
 * DATE: 2024/8/7 15:21
 */
public class SceneConflictException extends RuntimeException {
    public SceneConflictException() {
        super();
    }

    public SceneConflictException(String message) {
        super(message);
    }

    public SceneConflictException(String message, Throwable cause) {
        super(message, cause);
    }

    public SceneConflictException(Throwable cause) {
        super(cause);
    }
}
