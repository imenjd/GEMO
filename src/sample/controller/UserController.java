package sample.controller;
import sample.entities.User;
import sample.daoimpl.UserDaoImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

public class UserController {
	public boolean sample(String userName, String password) {
		User user;
		UserDaoImpl dao = new UserDaoImpl();
		user = dao.selectByUserName(userName);
		
		if (userName.equals(user.getUserName()) && password.equals(user.getPassword())) {
			return true;
		} else {
			return false;
		}
	}
	
	public String sessionStorage(String userName) {
		User user;
		UserDaoImpl dao = new UserDaoImpl();
		user = dao.selectByUserName(userName);
		String id=user.getId();
		return id;
		
	}
	
	
	public ObservableList fillTable () {
		
		
		UserDaoImpl alluzers = new UserDaoImpl();
		
		List<User> uzers = alluzers.selectAll();
		ObservableList<User> obluzers = FXCollections.observableArrayList();
		for (User p : uzers) {
			obluzers.add(p);
		}
		
		return obluzers;
	}
	
	public void delete (int id) {
		
		UserDaoImpl dao = new UserDaoImpl();
		dao.delete(id);
	}
}
