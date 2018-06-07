package sample.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.entities.Service;
import sample.daoimpl.ServiceDaoImpl;

import java.util.List;

public class ServiceController {
	public ServiceController(){}
	
	
	

	
	public  void add (String name ) {
		
		ServiceDaoImpl hedi = new ServiceDaoImpl();
		Service service = new Service();
		service.setName(name);
		hedi.insert(service);
		
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
