package com.tunjix.poplaroot.api.entty;

/**
 * AUTHOR: XirALi · MaMat（西尔艾力·买买提）
 * DATE: 2024/8/25 12:29
 */
public class CircuitBreakerInfo {
    /**
     * true 代表不阻断
     */
    private boolean success = true;
    /**
     * 阻断后的返回值
     */
    private Object returnValue;

    public CircuitBreakerInfo() {
    }

    public CircuitBreakerInfo(boolean success) {
        this.success = success;
    }

    public CircuitBreakerInfo(boolean success, Object returnValue) {
        this.success = success;
        this.returnValue = returnValue;
    }
    
    public boolean getSuccess() {
        return success;
    }
    
    public void setSuccess(boolean success) {
        this.success = success;
    }
    
    public Object getReturnValue() {
        return returnValue;
    }
    
    public void setReturnValue(Object returnValue) {
        this.returnValue = returnValue;
    }
}
