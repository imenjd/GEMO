package sample.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.entities.Intervention;
import sample.daoimpl.InterventionDaoImpl;

import java.util.List;

public class InterventionController {
	public InterventionController() {
	}
	public static void insert(String name){
		Intervention intervention=new Intervention();
		intervention.setName(name);
		InterventionDaoImpl dao=new InterventionDaoImpl();
		dao.insert(intervention);
	}

	public static ObservableList fillTable() {
		
		
		InterventionDaoImpl allservices = new InterventionDaoImpl();
		
		List<Intervention> services = allservices.selectAll();
		ObservableList<Intervention> oblservices = FXCollections.observableArrayList();
		for (Intervention p : services) {
			oblservices.add(p);
		}
		
		return oblservices;
	}
}
