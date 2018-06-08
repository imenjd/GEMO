package sample.controller;

import sample.daoimpl.SearchDetailsDaoImpl;

import java.util.List;

public class ControllerDetails {
	public List<String> fillFields(String val){
		SearchDetailsDaoImpl dao=new SearchDetailsDaoImpl();
		List<String> s=dao.SearchById(val);
		
		return s;
	}
}
