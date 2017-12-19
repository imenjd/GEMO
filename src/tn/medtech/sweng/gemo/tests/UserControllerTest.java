package tn.medtech.sweng.gemo.tests;

import tn.medtech.sweng.gemo.controller.UserController;

import static org.junit.Assert.*;

public class UserControllerTest {
    @org.junit.Test
    public void viewtest() throws Exception {
        UserController ctrl = new UserController();

        boolean x=ctrl.sample("khalil", "khalil");
        assertEquals(true,x);
    }


}