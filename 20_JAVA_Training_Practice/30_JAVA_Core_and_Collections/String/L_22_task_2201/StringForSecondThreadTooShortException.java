package com.company;

public class StringForSecondThreadTooShortException extends RuntimeException {
    @Override
    public synchronized Throwable getCause() {
        return new StringIndexOutOfBoundsException();
    }
}
