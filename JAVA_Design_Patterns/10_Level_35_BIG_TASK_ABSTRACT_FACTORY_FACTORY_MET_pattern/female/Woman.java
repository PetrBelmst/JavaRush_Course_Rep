package com.company.female;

import com.company.Human;

public class Woman implements Human {

    public static final int MAX_AGE = 12;

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{}";
    }
}
