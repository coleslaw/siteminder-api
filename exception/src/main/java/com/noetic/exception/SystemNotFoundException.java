package com.noetic.exception;

/**
 * Ruwan Chathuranga on 06-July-2018
 */
public class SystemNotFoundException extends Exception{
    
    public SystemNotFoundException() {
        super();
    }

    public SystemNotFoundException(String message) {
        super(message);
    }

    public SystemNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public SystemNotFoundException(Throwable cause) {
        super(cause);
    }

    protected SystemNotFoundException(String message, Throwable cause, boolean enableSuppression,
            boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
