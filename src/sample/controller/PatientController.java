package sample.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.entities.Patient;
import sample.daoimpl.PatientDaoImpl;


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
	
	

	
	public ObservableList fillTable () {
		
		
		PatientDaoImpl allservices = new PatientDaoImpl();
		
		List<Patient> services = allservices.selectAll();
		ObservableList<Patient> oblservices = FXCollections.observableArrayList();
		for (Patient p : services) {
			oblservices.add(p);
		}
		
		return oblservices;
	}
	public int SearchLastID(){
		PatientDaoImpl dao=new PatientDaoImpl();
		return dao.searchLast();
	}
}
