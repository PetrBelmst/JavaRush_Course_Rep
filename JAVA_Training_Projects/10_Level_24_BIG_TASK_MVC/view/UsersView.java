package com.company.view;

import com.company.controller.Controller;
import com.company.model.ModelData;
import com.company.bean.User;

import java.util.List;

public class UsersView implements View {

    private Controller controller;

    @Override
    public void refresh(ModelData modelData) {
        if(!modelData.isDisplayDeletedUserList()) {
            System.out.println("All users:");
        }else {
            System.out.println("All deleted users:");
        }
        List<User> list = modelData.getUsers();
        for (int i = 0; i < list.size(); i++) {
            System.out.print("\t");
            System.out.println(list.get(i));
        }
        System.out.println("===================================================");
    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void fireEventShowAllUsers() {
        controller.onShowAllUsers();
    }

    public void fireEventShowDeletedUsers() {
        controller.onShowAllDeletedUsers();
    }

    public void fireEventOpenUserEditForm(long id){
        controller.onOpenUserEditForm(id);
    }
}
