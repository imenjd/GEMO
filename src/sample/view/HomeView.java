package sample.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.entities.User;

import java.io.IOException;

public class HomeView {
	
	public void Home (Scene scene,String b) {
		
		try {
			Button Home;
			Home = (Button)scene.lookup("#Home");
			
			Home.setOnAction(event -> {
				
				FXMLLoader Loader = new FXMLLoader(getClass().getResource("../view/fxml/Home.fxml"));
				Parent root = null;
				try {
					root =  Loader.load();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				
				HomeView dview = new HomeView();
				Scene sc2=new Scene(root,840,562);
				Stage newstage =  (Stage)((Node) event.getSource()).getScene().getWindow();
				newstage.setScene(sc2);
				newstage.show();
				TextField username =(TextField) sc2.lookup("#txtUserName");
				username.setText(b);
				
				SearchView searchView=new SearchView();
				searchView.fillCombobox(sc2);
				searchView.filltable(sc2);
				searchView.addVisit(sc2,b);
				searchView.logout(sc2);
				searchView.Dashboard(sc2,b);
				
				
			});
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	
	public void dci (Scene scene,String b) {
		
		try {
			Button dci=(Button)scene.lookup("#Dcibtn");
			
			dci.setOnAction(event -> {
				
				FXMLLoader Loader = new FXMLLoader(getClass().getResource("../view/fxml/Dci.fxml"));
				Parent root = null;
				try {
					root =  Loader.load();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				//HomeView dview = new HomeView();
				//String u=dview.SessionStorage(scene);
				UserView a=new UserView();
				
				
				Scene sc2 = new Scene(root, 596, 638);
				Stage newstage =  (Stage)((Node) event.getSource()).getScene().getWindow();
				newstage.setScene(sc2);
				newstage.show();
				TextField username =(TextField) sc2.lookup("#txtUserName");
				username.setText(b);
				DciView view3 = new DciView();
				view3.fillTable(sc2);
				view3.add(sc2);
				view3.delete(sc2);
				view3.update(sc2);
				view3.Dashboard(sc2,b);
				
				
				
			});
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	public void med (Scene scene,String b) {
		
		try {
			Button med=(Button)scene.lookup("#MedBtn");
			
			med.setOnAction(event -> {
				
				FXMLLoader Loader = new FXMLLoader(getClass().getResource("../view/fxml/Medicament.fxml"));
				Parent root = null;
				try {
					root =  Loader.load();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				//HomeView dview = new HomeView();
				//String u=dview.SessionStorage(scene);
				//User a =new User();
				UserView a=new UserView();
				Scene sc2 = new Scene(root, 730, 510);
				Stage newstage =  (Stage)((Node) event.getSource()).getScene().getWindow();
				newstage.setScene(sc2);
				newstage.show();
				TextField username =(TextField) sc2.lookup("#txtUserName");
				username.setText(b);
				MedView view1 = new MedView();
				view1.fillTable2(sc2);
				view1.add2(sc2);
				
				view1.Dashboard(sc2,b);
				
				
			});
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
	public void problem (Scene scene,String b) {
		
		try {
			Button problem=(Button)scene.lookup("#ProbBtn");
			
			problem.setOnAction(event -> {
				
				FXMLLoader Loader = new FXMLLoader(getClass().getResource("../view/fxml/Problem.fxml"));
				Parent root = null;
				try {
					root =  Loader.load();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				//HomeView dview = new HomeView();
				//String u=dview.SessionStorage(scene);
				User a=new User();
				
				Scene sc2 = new Scene(root, 730, 520);
				Stage newstage =  (Stage)((Node) event.getSource()).getScene().getWindow();
				newstage.setScene(sc2);
				newstage.show();
				TextField username =(TextField) sc2.lookup("#txtUserName");
				username.setText(b);
				ProblemView view = new ProblemView();
				view.insert(sc2);
			
				view.fillTable(sc2);
		
				view.Dashboard(sc2,b);
				
				
			});
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	public void intervention (Scene scene,String b) {
		
		try {
			Button problem=(Button)scene.lookup("#InterBtn");
			
			problem.setOnAction(event -> {
				
				FXMLLoader Loader = new FXMLLoader(getClass().getResource("../view/fxml/Intervention.fxml"));
				Parent root = null;
				try {
					root =  Loader.load();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				//HomeView dview = new HomeView();
				//String u=dview.SessionStorage(scene);
				User a=new User();
				Scene sc2 = new Scene(root, 730, 510);
				Stage newstage =  (Stage)((Node) event.getSource()).getScene().getWindow();
				newstage.setScene(sc2);
				newstage.show();
				TextField username =(TextField) sc2.lookup("#txtUserName");
				username.setText(b);
				InterventionView view = new InterventionView();
				view.Dashboard(sc2,b);
				view.insert(sc2);
				view.fillTable(sc2);
				
				
				
				
				
				
			});
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	
	public void service (Scene scene,String b) {
		
		try {
			Button service=(Button)scene.lookup("#ServiceBtn");
			
			service.setOnAction(event -> {
				
				FXMLLoader Loader = new FXMLLoader(getClass().getResource("../view/fxml/Service.fxml"));
				Parent root = null;
				try {
					root =  Loader.load();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				//HomeView dview = new HomeView();
				//String u=dview.SessionStorage(scene);
				User a=new User();
				
				Scene sc2 = new Scene(root, 596, 638);
				Stage newstage =  (Stage)((Node) event.getSource()).getScene().getWindow();
				newstage.setScene(sc2);
				newstage.show();
				TextField username =(TextField) sc2.lookup("#txtUserName");
				username.setText(b);
				
				ServiceView view = new ServiceView();
				view.fillTable(sc2);
				view.add(sc2);
				
				view.Dashboard(sc2,b);
				
				
				
			});
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	public void patient (Scene scene,String b) {
		
		try {
			Button service=(Button)scene.lookup("#PatientsBtn");
			
			service.setOnAction(event -> {
				
				FXMLLoader Loader = new FXMLLoader(getClass().getResource("../view/fxml/PatientList.fxml"));
				Parent root = null;
				try {
					root =  Loader.load();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				//HomeView dview = new HomeView();
				//String u=dview.SessionStorage(scene);
				User a=new User();
				
				Scene sc2 = new Scene(root, 596, 638);
				Stage newstage =  (Stage)((Node) event.getSource()).getScene().getWindow();
				newstage.setScene(sc2);
				newstage.show();
				TextField username =(TextField) sc2.lookup("#txtUserName");
				username.setText(b);
				PatientView view=new PatientView();
				//ServiceView view = new ServiceView();
				view.fillTable(sc2);
				
				
				view.Dashboard(sc2,b);
				
				
				
			});
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	public void userpending (Scene scene,String b) {
		
		try {
			Button userpending=(Button)scene.lookup("#UserPendingBtn");
			
			userpending.setOnAction(event -> {
				
				FXMLLoader Loader = new FXMLLoader(getClass().getResource("../view/fxml/UserPending.fxml"));
				Parent root = null;
				try {
					root =  Loader.load();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				//HomeView dview = new HomeView();
				//String u=dview.SessionStorage(scene);
				User a=new User();
				
				Scene sc2 = new Scene(root);
				Stage newstage =  (Stage)((Node) event.getSource()).getScene().getWindow();
				newstage.setScene(sc2);
				newstage.show();
				TextField username =(TextField) sc2.lookup("#txtUserName");
				username.setText(b);
				
				UserPendingView view = new UserPendingView();
				view.fillTable(sc2);
				view.reject(sc2);
				view.accept(sc2);
				view.UserInfo(sc2);
				view.Dashboard(sc2,b);
				
				
			});
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	public void user (Scene scene,String b) {
		
		
		try {
			Button user=(Button)scene.lookup("#UsersBtn");
			
			user.setOnAction(event -> {
				
				FXMLLoader Loader = new FXMLLoader(getClass().getResource("../view/fxml/Users.fxml"));
				Parent root = null;
				try {
					root =  Loader.load();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				//HomeView dview = new HomeView();
				//String u=dview.SessionStorage(scene);
				User a =new User();
				Scene sc2 = new Scene(root);
				Stage newstage =  (Stage)((Node) event.getSource()).getScene().getWindow();
				newstage.setScene(sc2);
				newstage.show();
				
				TextField username =(TextField) sc2.lookup("#txtUserName");
				username.setText(b);
				UserView uview = new UserView();
				uview.fillTable(sc2);
				
				UserDashboardView view = new UserDashboardView();
				view.Dashboard(sc2,b);
				
				uview.fillTable(sc2);
				
				
				
			});
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	
}
