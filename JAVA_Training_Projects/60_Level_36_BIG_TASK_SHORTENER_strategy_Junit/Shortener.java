package com.company;

import com.company.strategy.StorageStrategy;

public class Shortener {

    private Long lastId = (long) 0;
    private StorageStrategy storageStrategy;

    public Shortener(StorageStrategy storageStrategy) {
        this.storageStrategy = storageStrategy;
    }

    public synchronized Long getId(String string) {
        if (storageStrategy.containsValue(string)) {
            return storageStrategy.getKey(string);
        } else {
            lastId++;
            storageStrategy.put(lastId, string);
            return lastId;
        }
    }

    public synchronized String getString(Long id) {
        return storageStrategy.getValue(id);
    }


}