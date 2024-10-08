package com.tunjix.poplaroot.common.exceptions;

/**
 * AUTHOR: XirALi · MaMat（西尔艾力·买买提）
 * DATE: 2024/8/7 15:21
 */
public class NoAnnotationException extends RuntimeException {
    public NoAnnotationException() {
        super();
    }

    public NoAnnotationException(String message) {
        super(message);
    }

    public NoAnnotationException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoAnnotationException(Throwable cause) {
        super(cause);
    }
}
