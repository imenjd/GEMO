package tn.medtech.sweng.gemo.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import tn.medtech.sweng.gemo.daoimpl.UserDaoImpl;
import tn.medtech.sweng.gemo.entities.User;

import java.util.List;

public class UserController {

    public boolean sample(String userName, String password) {
        User user;
        UserDaoImpl dao = new UserDaoImpl();
        user = dao.selectByUserName(userName);

        if (userName.equals(user.getUserName()) && password.equals(user.getPassword())) {
            return true;
        } else {
            return false;
        }
    }


    public  ObservableList fillTable () {


        UserDaoImpl alluzers = new UserDaoImpl();

        List<User> uzers = alluzers.selectAll();
        ObservableList<User> obluzers = FXCollections.observableArrayList();
        for (User p : uzers) {
            obluzers.add(p);
        }

        return obluzers;
    }
}
