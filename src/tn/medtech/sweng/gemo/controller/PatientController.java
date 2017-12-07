package tn.medtech.sweng.gemo.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import tn.medtech.sweng.gemo.entities.Patient;
import tn.medtech.sweng.gemo.daoimpl.PatientDaoImpl;

import java.util.List;


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


    public ObservableList fillTable () {


        PatientDaoImpl allservices = new PatientDaoImpl();

        List<Patient> services = allservices.selectAll();
        ObservableList<Patient> oblservices = FXCollections.observableArrayList();
        for (Patient p : services) {
            oblservices.add(p);
        }

        return oblservices;
    }


}
