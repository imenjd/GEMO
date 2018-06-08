package sample.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.entities.Med;
import sample.daoimpl.MedDaoImpl;
import java.util.List;

public class MedController {
	public MedController(){}
	
	
	
	public  void add2 (String name ) {
		
		MedDaoImpl medDao1 = new MedDaoImpl();
		Med med = new Med();
	
		med.setName(name);
		medDao1.insert(med);
		
	}
	
	
	public static ObservableList fillTable2 () {
		
		
		MedDaoImpl allmeds = new MedDaoImpl();
		
		List<Med> meds = allmeds.selectAll();
		ObservableList<Med> oblmeds = FXCollections.observableArrayList();
		for (Med p : meds) {
			oblmeds.add(p);
		}
		
		return oblmeds;
	}
	
	
}
