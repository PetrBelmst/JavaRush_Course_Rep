package com.company;

public class StringForFirstThreadTooShortException extends RuntimeException {
    @Override
    public synchronized Throwable getCause() {
        return new StringIndexOutOfBoundsException();
    }
}