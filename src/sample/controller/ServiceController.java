package sample.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.entities.Service;
import sample.daoimpl.ServiceDaoImpl;

import java.util.List;

public class ServiceController {
	public ServiceController(){}
	
	
	
	public  void delete (int d) {
		
		ServiceDaoImpl dao = new ServiceDaoImpl();
		dao.delete(d);
	}
	
	public  void update (int id, String name , int x) {
		
		ServiceDaoImpl dao = new ServiceDaoImpl();
		Service service = new Service();
		
		service.setId(id);//controller
		service.setName(name);//controller
		
		dao.update(service, x);//controller
		
	}
	
	public  void add (String name ) {
		
		ServiceDaoImpl hedi = new ServiceDaoImpl();
		Service service = new Service();
		service.setName(name);
		hedi.insert(service);
		
	}
	
	public boolean checkId (int id) {
		ServiceDaoImpl dao = new ServiceDaoImpl();
		if (dao.checkId(id) >= 0)
			return true;
		else
			return false;
	}
	
	
	public ObservableList fillTable () {
		
		
		ServiceDaoImpl allservices = new ServiceDaoImpl();
		
		List<Service> services = allservices.selectAll();
		ObservableList<Service> oblservices = FXCollections.observableArrayList();
		for (Service p : services) {
			oblservices.add(p);
		}
		
		return oblservices;
	}
}
