package tn.medtech.sweng.gemo;
import tn.medtech.sweng.gemo.daoimpl.PatientDaoImpl;
import tn.medtech.sweng.gemo.daoimpl.ServiceDaoImpl;
import tn.medtech.sweng.gemo.daoimpl.UserPendingDaoImpl;
import tn.medtech.sweng.gemo.entities.Patient;
import tn.medtech.sweng.gemo.entities.Service;
import tn.medtech.sweng.gemo.entities.UserPending;
import tn.medtech.sweng.gemo.util.ConnectionConfiguration;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        //ServiceDaoImpl hedi = new ServiceDaoImpl();
        //Service hed = new Service(3,"no");
        //hedi.insert(hed);
        //hedi.update(hed, 9);
        //hedi.delete(20);
        //System.out.println(hedi.selectAllNames());



        ///hed=hedi.selectByName("iii");
        //System.out.println(hed.getId()+" , "+hed.getName());
        //System.out.println(hedi.checkId(3));
        //UserPendingDaoImpl dao = new UserPendingDaoImpl();
        //ServiceDaoImpl dd = new ServiceDaoImpl();
        //UserPending ena = new UserPending( "no", "nno", "khlffil","doffctor ", "khlfffffil.@.com","henooffo");
        //dao.insert(ena);
        //dao.delete(4);
        /*List<Service> persons = dd.selectAll();
        for (Service p : persons)
        {
            System.out.println(p.getId()+" , "+p.getName());
        }


        System.out.println();

        List<UserPending> users = dao.selectAll();
        for (UserPending u : users)
        {
            System.out.println(u.getId()+" , "+u.getFirstName()+" , "+u.getLastName()+" , "+u.getUserName()+" , "+u.getStatus()+" , "+u.getEmail()+" , "+u.getPassword());
        }

*/


    }
}
