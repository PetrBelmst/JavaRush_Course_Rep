package com.company;

import java.util.ArrayList;
import java.util.List;

public class Service {

    public List<String> getData() {
        List<String> data = new ArrayList<String>() {
            {
                add("First string");
                add("Second string");
                add("Third string");
            }
        };
        return data;
    }

}
