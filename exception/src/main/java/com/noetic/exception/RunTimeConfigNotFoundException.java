package com.noetic.exception;

/**
 * Ruwan Chathuranga on 06-July-2018
 */
public class RunTimeConfigNotFoundException extends Exception {

    public RunTimeConfigNotFoundException() {
        super();
    }

    public RunTimeConfigNotFoundException(String message) {
        super(message);
    }

    public RunTimeConfigNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public RunTimeConfigNotFoundException(Throwable cause) {
        super(cause);
    }

    protected RunTimeConfigNotFoundException(String message, Throwable cause, boolean enableSuppression,
            boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
