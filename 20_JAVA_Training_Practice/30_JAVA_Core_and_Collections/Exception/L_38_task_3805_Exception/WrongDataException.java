package com.company;

public class WrongDataException extends Exception {
    public WrongDataException() {
        super();
    }

    public WrongDataException(String message) {
        super(message);
    }
}
