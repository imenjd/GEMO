package sample.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.entities.Problem;
import sample.daoimpl.ProblemDaoImpl;
import java.util.List;

public class ProblemController {
	public ProblemController() {
	}
	public static void insert(String name){
		Problem problem=new Problem();
		problem.setName(name);
		ProblemDaoImpl dao=new ProblemDaoImpl();
		dao.insert(problem);
	}
	
	
	
	public ObservableList fillTable () {
		
		
		ProblemDaoImpl allservices = new ProblemDaoImpl();
		
		List<Problem> services = allservices.selectAll();
		ObservableList<Problem> oblservices = FXCollections.observableArrayList();
		for (Problem p : services) {
			oblservices.add(p);
		}
		
		return oblservices;
	}
}
