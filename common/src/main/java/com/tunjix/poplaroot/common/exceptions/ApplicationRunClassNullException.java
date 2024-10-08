package com.tunjix.poplaroot.common.exceptions;

/**
 * AUTHOR: XirALi · MaMat（西尔艾力·买买提）
 * DATE: 2024/8/7 15:21
 */
public class ApplicationRunClassNullException extends RuntimeException {
    public ApplicationRunClassNullException() {
        super();
    }

    public ApplicationRunClassNullException(String message) {
        super(message);
    }

    public ApplicationRunClassNullException(String message, Throwable cause) {
        super(message, cause);
    }

    public ApplicationRunClassNullException(Throwable cause) {
        super(cause);
    }
}
