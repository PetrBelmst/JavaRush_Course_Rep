package com.company.view;

import com.company.controller.Controller;
import com.company.model.ModelData;

public interface View {

    void refresh(ModelData modelData);

    void setController(Controller controller);

}
