package tn.medtech.sweng.gemo.tests;

import tn.medtech.sweng.gemo.daoimpl.ServiceDaoImpl;
import tn.medtech.sweng.gemo.entities.Service;

import static org.junit.Assert.*;

public class ServiceDaoImplTest {
    @org.junit.Test
    public void insert() throws Exception {

        ServiceDaoImpl x = new ServiceDaoImpl();
        Service y = new Service(5,"newservice");
       // x.insert(y);
        String a=x.selectById(5).getName();
        assertEquals("newservice", a );

    }

    @org.junit.Test
    public void update() throws Exception {


    }

    @org.junit.Test
    public void delete() throws Exception {


    }

    @org.junit.Test
    public void selectByName() throws Exception {
    }

    @org.junit.Test
    public void selectById() throws Exception {
    }

    @org.junit.Test
    public void selectAll() throws Exception {
    }

}