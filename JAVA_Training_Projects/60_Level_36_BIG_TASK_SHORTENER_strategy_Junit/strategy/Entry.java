package com.company.strategy;

import java.io.Serializable;

public class Entry implements Serializable {

    int hash;
    Long key;
    String value;
    Entry next;

    public Entry(int hash, Long key, String value, Entry next) {
        this.key = key;
        this.value = value;
        this.next = next;
        this.hash = hash;
    }

    public Long getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    @Override
    public int hashCode() {
        return (key == null ? 0 : key.hashCode()) ^ (value == null ? 0 : value.hashCode());
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Entry))
            return false;

        Long key1 = getKey();
        Long key2 = ((Entry) o).getKey();
        String value1 = getValue();
        String value2 = ((Entry) o).getValue();
        if (key1 == key2 || (key1 != null && key1.equals(key2))) {
            if (value1 == value2 || (value1 != null && value1.equals(value2))) {
                return true;
            }
        }

        return false;
    }

    @Override
    public String toString() {
        return key + "=" + value;
    }
}

