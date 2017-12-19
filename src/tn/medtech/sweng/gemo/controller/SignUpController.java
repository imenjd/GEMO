package tn.medtech.sweng.gemo.controller;

import tn.medtech.sweng.gemo.daoimpl.UserDaoImpl;
import tn.medtech.sweng.gemo.daoimpl.UserPendingDaoImpl;
import tn.medtech.sweng.gemo.entities.UserPending;

import java.util.List;

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


    public static boolean checkUsername(String x) {

        UserDaoImpl dao= new UserDaoImpl();
        List<String> names = dao.selectAllNames();
        for (String n : names)
        {
            if(x.equals(n)) {
                return false;
            }
        }
        return true;



    }


    public static boolean doesPasswordMatch(String p, String p2) {
        if (p.equals(p2)){
            return true;}
        else {
            return  false;
        }
    }
}

