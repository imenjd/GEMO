package tn.medtech.sweng.gemo.dao;
import tn.medtech.sweng.gemo.entities.Patient;
public interface PatientDao {

    void insert(Patient patient);
    void update(Patient patient, int id);
}
