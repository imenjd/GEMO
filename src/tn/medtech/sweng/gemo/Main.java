package tn.medtech.sweng.gemo;
import tn.medtech.sweng.gemo.daoimpl.PatientDaoImpl;
import tn.medtech.sweng.gemo.daoimpl.ServiceDaoImpl;
import tn.medtech.sweng.gemo.entities.Patient;
import tn.medtech.sweng.gemo.entities.Service;
import tn.medtech.sweng.gemo.util.ConnectionConfiguration;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        ServiceDaoImpl hedi = new ServiceDaoImpl();
        Service hed = new Service(3,"no");
        hedi.insert(hed);
        //hedi.update(hed, 9);
        //hedi.delete(20);




        ///hed=hedi.selectByName("iii");
        //System.out.println(hed.getId()+" , "+hed.getName());
        //System.out.println(hedi.checkId(3));


    }
}
