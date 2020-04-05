package com.company;


import java.util.List;

public class Model {

    static Service service = new Service();


    public List<String> getStringDataList() {
        return service.getData();
    }
}
