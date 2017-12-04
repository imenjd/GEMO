package tn.medtech.sweng.gemo.controller;

import tn.medtech.sweng.gemo.daoimpl.UserDaoImpl;
import tn.medtech.sweng.gemo.entities.User;

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
}
