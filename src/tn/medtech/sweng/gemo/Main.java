package tn.medtech.sweng.gemo;
import tn.medtech.sweng.gemo.daoimpl.PatientDaoImpl;
import tn.medtech.sweng.gemo.daoimpl.ServiceDaoImpl;
import tn.medtech.sweng.gemo.entities.Patient;
import tn.medtech.sweng.gemo.entities.Service;
import tn.medtech.sweng.gemo.util.ConnectionConfiguration;
public class Main {
    public static void main(String[] args) {

        ServiceDaoImpl hedi = new ServiceDaoImpl();
        Service hed = new Service(6,"UH");
        hedi.insert(hed);
        hedi.update(hed, "imen");
        //hedi.delete("imaaan");

        //hed=hedi.selectByName("US");
        //System.out.println(hedi.selectById(2).getId()+" , "+hedi.selectById(2).getName());

    }
}
