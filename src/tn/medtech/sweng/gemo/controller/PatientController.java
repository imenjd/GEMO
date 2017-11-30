package tn.medtech.sweng.gemo.controller;


public class Controller {
    public Controller() {
    }

    public static void add(String f,String l,String d){
        Patient patient=new Patient();
        patient.setFirstName(f);
        patient.setLastName(l);
        patient.setBirthDate(d);
        PatientDao dao=new PatientDao();
        dao.insert(patient);
    }
    public static void update(String f,String l,String d,int id){
        Patient patient =new Patient();
        patient.setFirstName(f);
        patient.setLastName(l);
        patient.setBirthDate(d);
        PatientDao dao=new PatientDao();
        dao.update(patient,id);
    }
    public static boolean exist(int id){
        PatientDao dao=new PatientDao();

        return dao.exist(id);
    }
}
