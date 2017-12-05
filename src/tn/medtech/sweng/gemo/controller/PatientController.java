package tn.medtech.sweng.gemo.controller;

import tn.medtech.sweng.gemo.entities.Patient;
import tn.medtech.sweng.gemo.daoimpl.PatientDaoImpl;


public class PatientController {
    public PatientController() {
    }

    public static void add(String f, String l, String d) {
        Patient patient = new Patient();
        patient.setFirstName(f);
        patient.setLastName(l);
        patient.setBirthDate(d);
        PatientDaoImpl dao = new PatientDaoImpl();
        dao.insert(patient);
    }

    public static void update(String f, String l, String d, int id) {
        Patient patient = new Patient();
        patient.setFirstName(f);
        patient.setLastName(l);
        patient.setBirthDate(d);
        PatientDaoImpl dao = new PatientDaoImpl();
        dao.update(patient, id);
    }

    public static boolean exist(int id) {
        PatientDaoImpl dao = new PatientDaoImpl();

        return dao.exist(id);
    }
}
