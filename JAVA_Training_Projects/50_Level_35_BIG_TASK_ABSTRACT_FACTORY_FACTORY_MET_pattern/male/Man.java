package com.company.male;

import com.company.Human;

public class Man implements Human {

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{}";
    }
}
