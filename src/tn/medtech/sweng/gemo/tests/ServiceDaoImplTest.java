package tn.medtech.sweng.gemo.tests;

import tn.medtech.sweng.gemo.daoimpl.ServiceDaoImpl;
import tn.medtech.sweng.gemo.entities.Service;

import static org.junit.Assert.*;

public class ServiceDaoImplTest {
    @org.junit.Test
    public void insert() throws Exception {

        ServiceDaoImpl x = new ServiceDaoImpl();
        Service y = new Service(200,"insertTestService");
        x.insert(y);
        String a=x.selectById(200).getName();
        assertEquals("insertTestService", a );

    }

    @org.junit.Test
    public void update() throws Exception {

        ServiceDaoImpl a = new ServiceDaoImpl();
        Service b = new Service(200,"updateTestService");
        a.update(b,200);
        String x=a.selectById(200).getName();
        assertEquals("updateTestService", x );


    }

    @org.junit.Test
    public void delete() throws Exception {
        ServiceDaoImpl a = new ServiceDaoImpl();
        a.delete(200);
        assertEquals(-1, a.checkId(200) );
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