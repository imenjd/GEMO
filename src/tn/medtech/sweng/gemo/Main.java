package tn.medtech.sweng.gemo;
import tn.medtech.sweng.gemo.daoimpl.PatientDaoImpl;
import tn.medtech.sweng.gemo.daoimpl.ServiceDaoImpl;
import tn.medtech.sweng.gemo.daoimpl.UserDaoImpl;
import tn.medtech.sweng.gemo.daoimpl.UserPendingDaoImpl;
import tn.medtech.sweng.gemo.entities.Patient;
import tn.medtech.sweng.gemo.entities.Service;
import tn.medtech.sweng.gemo.entities.User;
import tn.medtech.sweng.gemo.entities.UserPending;
import tn.medtech.sweng.gemo.util.ConnectionConfiguration;

import java.util.ArrayList;
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
        UserDaoImpl dao = new UserDaoImpl();
        //User ena = new User( "the man", "hero", "owner2","manager ", "kkk@.@.com","lalalalal",true);
        //dao.insert(ena);
       /* dao.selectAllNames();
        System.out.println(dao.selectAllNames());
        List<String> names = dao.selectAllNames();
        for (String n : names)
        {
            System.out.println(n);
            if(x=n)
                return false;
        }
        return true;*/
        //ServiceDaoImpl dd = new ServiceDaoImpl();

        //dao.insert(ena);
        //dao.delete(5);
        /*List<Service> persons = dd.selectAll();
        for (Service p : persons)
        {
            System.out.println(p.getId()+" , "+p.getName());
        }
*/



        /*List<UserPending> users = dao.selectAll();
        for (UserPending u : users)
        {
            System.out.println(u.getId()+" , "+u.getFirstName()+" , "+u.getLastName()+" , "+u.getUserName()+" , "+u.getStatus()+" , "+u.getEmail()+" , "+u.getPassword()+" , "+u.isAdmin());
        }

        System.out.println();
        System.out.println(222);
        System.out.println();
        System.out.println(dao.selectById(7));
        System.out.println(dao.selectById(7).getId()+" , "+dao.selectById(7).getFirstName()+" , "+dao.selectById(7).getLastName()+" , "+dao.selectById(7).getUserName()+" , "+dao.selectById(7).getStatus()+" , "+dao.selectById(7).getEmail()+" , "+dao.selectById(7).getPassword()+" , "+dao.selectById(7).isAdmin());

*/

    }
}
