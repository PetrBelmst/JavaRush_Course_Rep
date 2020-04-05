package com.company;

import java.util.List;

public class Controller {

    static Model model = new Model();

    public List<String> onShowDataList() {
        return model.getStringDataList();
    }
}
