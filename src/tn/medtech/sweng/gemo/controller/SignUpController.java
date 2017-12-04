package tn.medtech.sweng.gemo.controller;

import tn.medtech.sweng.gemo.daoimpl.UserPendingDaoImpl;
import tn.medtech.sweng.gemo.entities.UserPending;

public class SignUpController {
    public  void add (String firstName, String LastName, String userName, String password, String email, String status,String pass2, boolean Admin ) {


        UserPendingDaoImpl dao = new UserPendingDaoImpl();
        UserPending userp = new UserPending();


        userp.setFirstName(firstName);
        userp.setLastName(LastName);
        userp.setUserName(userName);
        userp.setPassword(password);
        userp.setEmail(email);
        userp.setStatus(status);
        userp.setAdmin(Admin);
        dao.insert(userp);
    }


    public static boolean doesPasswordMatch(String p, String p2) {
        if (p.equals(p2)){
            return true;}
        else {
            return  false;
        }
    }
}

