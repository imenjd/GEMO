package tn.medtech.sweng.gemo.tests;

import tn.medtech.sweng.gemo.daoimpl.ServiceDaoImpl;
import tn.medtech.sweng.gemo.entities.Service;

import static org.junit.Assert.*;

public class ServiceDaoImplTest {
    @org.junit.Test
    public void insert() throws Exception {

        ServiceDaoImpl x = new ServiceDaoImpl();
        Service y = new Service(20,"insertTestService");
        x.insert(y);
        String a=x.selectById(20).getName();
        assertEquals("insertTestService", a );

    }

    @org.junit.Test
    public void update() throws Exception {

        ServiceDaoImpl a = new ServiceDaoImpl();
        Service b = new Service(20,"updateTestService");
        a.update(b,20);
        String x=a.selectById(20).getName();
        assertEquals("updateTestService", x );


    }

    @org.junit.Test
    public void delete() throws Exception {
        ServiceDaoImpl a = new ServiceDaoImpl();
        a.delete(20);
        //assertEquals("updateTestService", x );
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