package com.company;

import com.company.controller.Controller;
import com.company.model.MainModel;
import com.company.model.Model;
import com.company.view.EditUserView;
import com.company.view.UsersView;

public class Solution {
    public static void main(String[] args) {
        Model model = new MainModel();
        UsersView usersView = new UsersView();
        Controller controller = new Controller();
        EditUserView editUserView = new EditUserView();

        usersView.setController(controller);
        editUserView.setController(controller);

        controller.setModel(model);
        controller.setUsersView(usersView);
        controller.setEditUserView(editUserView);

        usersView.fireEventShowAllUsers();
        usersView.fireEventOpenUserEditForm(126);
        editUserView.fireEventUserDeleted(124);
        editUserView.fireEventUserChanged("Петров", 125, 2);
        usersView.fireEventShowDeletedUsers();

    }
}


/*

 */