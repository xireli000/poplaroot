package com.tunjix.poplaroot.common.exceptions;

/**
 * AUTHOR: XirALi · MaMat（西尔艾力·买买提）
 * DATE: 2024/8/7 15:21
 */
public class NoImplementationException extends RuntimeException {
    public NoImplementationException() {
        super();
    }

    public NoImplementationException(String message) {
        super(message);
    }

    public NoImplementationException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoImplementationException(Throwable cause) {
        super(cause);
    }
}
