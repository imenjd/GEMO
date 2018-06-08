package sample.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.entities.Dci;
import sample.daoimpl.DciDaoImpl;

import java.util.List;

public class DciController {
	
	
	
	public static ObservableList fillTable () {
		
		
		DciDaoImpl alldcis = new DciDaoImpl();
		
		List<Dci> dcis = alldcis.selectAll();
		ObservableList<Dci> obldcis = FXCollections.observableArrayList();
		for (Dci p : dcis) {
			obldcis.add(p);
		}
		
		return obldcis;
	}
	
}
