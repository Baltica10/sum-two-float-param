package com.stiki.pixels.sumapi.exception;

public abstract class CommonException extends RuntimeException {
    public CommonException(String message, Throwable cause) {
        super(message, cause);
    }
}