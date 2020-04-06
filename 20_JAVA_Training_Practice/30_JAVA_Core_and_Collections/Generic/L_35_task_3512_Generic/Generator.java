package com.company;

public class Generator<T> {
    public Class<T> clazz;

    public Generator (Class<T> clazz) {
        this.clazz = clazz;
    }
    T newInstance() throws IllegalAccessException, InstantiationException {
        return (T) clazz.newInstance();
    }
}

/*
original code
public class Generator<T> {
    T newInstance() {
        return new T();
    }
}
*/