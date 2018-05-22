package sample.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.entities.Dci;
import sample.daoimpl.DciDaoImpl;

import java.util.List;

public class DciController {
	
	public DciController(){}
	
	
	public  void delete (int d) {
		
		DciDaoImpl dcidao = new DciDaoImpl();
		dcidao.delete(d);
	}
	
	public  void update (int id, String name , int x) {
		
		DciDaoImpl dcidao = new DciDaoImpl();
		Dci dci = new Dci();
		
		dci.setId(id);
		dci.setName(name);
		
		dcidao.update(dci, x);
		
	}
	
	public  void add (int id, String name ) {
		
		DciDaoImpl dciDao1 = new DciDaoImpl();
		Dci dci = new Dci();
		dci.setId(id);
		dci.setName(name);
		
		dciDao1.insert(dci);
		
	}
	
	public boolean checkId (int id) {
		DciDaoImpl dao = new DciDaoImpl();
		if (dao.checkId(id) >= 0)
			return true;
		else
			return false;
	}
	
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
