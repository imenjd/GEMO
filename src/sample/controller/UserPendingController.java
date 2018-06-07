package sample.controller;
import sample.entities.UserPending;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.daoimpl.UserPendingDaoImpl;
import sample.entities.User;
import sample.daoimpl.UserDaoImpl;

import java.util.List;

public class UserPendingController {
	public static ObservableList fillTable () {
		
		
		UserPendingDaoImpl alluserpendings = new UserPendingDaoImpl();
		
		List<UserPending> userpendings = alluserpendings.selectAll();
		ObservableList<UserPending> obluserpendings = FXCollections.observableArrayList();
		for (UserPending p : userpendings) {
			obluserpendings.add(p);
		}
		
		return obluserpendings;
	}
	
	
	public  void reject (int d) {
		
		UserPendingDaoImpl userpendingdao = new UserPendingDaoImpl();
		userpendingdao.delete(d);
	}
	
	public  void accept (int d) {
		
		UserPendingDaoImpl dao = new UserPendingDaoImpl();
		UserPending userp=dao.selectById(d);
		String firstn=userp.getFirstName();
		String lastn=userp.getLastName();
		String username=userp.getUserName();
		String status=userp.getStatus();
		String email=userp.getEmail();
		String psw=userp.getPassword();
		boolean adm=userp.isAdmin();
		
		User user = new User(firstn,lastn,username,status,email,psw,adm);
		UserDaoImpl userdao = new UserDaoImpl();
		userdao.insert(user);
		
		
		dao.delete(d);
	}
}
