package sample.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.stage.Stage;



import java.io.IOException;
import java.net.URL;

public class HomeView {
	Parent Root;
	URL url;
	
	public void Home (Scene scene,String b) {
		Button Home;
		Home = (Button)scene.lookup("#Home");
		try {
			
			
			Home.setOnAction(event -> {
				
				url  = getClass().getClassLoader().getResource("sample/view/fxml/Home.fxml");
				try {
					Root = FXMLLoader.load(url);
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				
				Scene sc2=new Scene(Root,840,562);
				Stage newstage =  (Stage)((Node) event.getSource()).getScene().getWindow();
				newstage.setScene(sc2);
				newstage.show();
				newstage.setTitle("Accueil");
				TextField username =(TextField) sc2.lookup("#txtUserName");
				username.setText(b);
				
				SearchView searchView=new SearchView();
				SearchView.fillCombobox(sc2);
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
				
				url  = getClass().getClassLoader().getResource("sample/view/fxml/Dci.fxml");
				try {
					Root = FXMLLoader.load(url);
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				
				
				
				Scene sc2 = new Scene(Root, 730, 510);
				Stage newstage =  (Stage)((Node) event.getSource()).getScene().getWindow();
				newstage.setScene(sc2);
				newstage.setTitle("DCI");
				newstage.show();
				TextField username =(TextField) sc2.lookup("#txtUserName");
				username.setText(b);
				DciView view3 = new DciView();
				DciView.fillTable(sc2);
				
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
				
				url  = getClass().getClassLoader().getResource("sample/view/fxml/Medicament.fxml");
				try {
					Root = FXMLLoader.load(url);
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				
				Scene sc2 = new Scene(Root, 730, 510);
				Stage newstage =  (Stage)((Node) event.getSource()).getScene().getWindow();
				newstage.setScene(sc2);
				newstage.show();
				newstage.setTitle("Médicaments");
				TextField username =(TextField) sc2.lookup("#txtUserName");
				username.setText(b);
				MedView view1 = new MedView();
				MedView.fillTable2(sc2);
				MedView.add2(sc2);
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
				url  = getClass().getClassLoader().getResource("sample/view/fxml/Problem.fxml");
				try {
					Root = FXMLLoader.load(url);
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				
				
				Scene sc2 = new Scene(Root, 730, 510);
				Stage newstage =  (Stage)((Node) event.getSource()).getScene().getWindow();
				newstage.setScene(sc2);
				newstage.show();
				newstage.setTitle("Problèmes");
				TextField username =(TextField) sc2.lookup("#txtUserName");
				username.setText(b);
				ProblemView view = new ProblemView();
				ProblemView.insert(sc2);
			
				ProblemView.fillTable(sc2);
		
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
				
				url  = getClass().getClassLoader().getResource("sample/view/fxml/Intervention.fxml");
				try {
					Root = FXMLLoader.load(url);
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				
				
				Scene sc2 = new Scene(Root, 730, 510);
				Stage newstage =  (Stage)((Node) event.getSource()).getScene().getWindow();
				newstage.setScene(sc2);
				newstage.show();
				newstage.setTitle("Interventions");
				TextField username =(TextField) sc2.lookup("#txtUserName");
				username.setText(b);
				InterventionView view = new InterventionView();
				view.Dashboard(sc2,b);
				InterventionView.insert(sc2);
				InterventionView.fillTable(sc2);
				
				
				
				
				
				
			});
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	
	public void service (Scene scene,String b) {
		
		try {
			Button service=(Button)scene.lookup("#ServiceBtn");
			
			service.setOnAction(event -> {
				
				url  = getClass().getClassLoader().getResource("sample/view/fxml/Service.fxml");
				try {
					Root = FXMLLoader.load(url);
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				
				
				Scene sc2 = new Scene(Root, 730, 510);
				Stage newstage =  (Stage)((Node) event.getSource()).getScene().getWindow();
				newstage.setScene(sc2);
				newstage.show();
				newstage.setTitle("Services");
				TextField username =(TextField) sc2.lookup("#txtUserName");
				username.setText(b);
				
				ServiceView view = new ServiceView();
				ServiceView.fillTable(sc2);
				ServiceView.add(sc2);
				
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
				
				url  = getClass().getClassLoader().getResource("sample/view/fxml/PatientList.fxml");
				try {
					Root = FXMLLoader.load(url);
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				
				
				Scene sc2 = new Scene(Root, 730, 510);
				Stage newstage =  (Stage)((Node) event.getSource()).getScene().getWindow();
				newstage.setScene(sc2);
				newstage.show();
				newstage.setTitle("Patients");
				TextField username =(TextField) sc2.lookup("#txtUserName");
				username.setText(b);
				PatientView view=new PatientView();
				PatientView.fillTable(sc2);
				
				
				view.Dashboard(sc2,b);
				
				
				
			});
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	public void userpending (Scene scene,String b) {
		Button user_pending=(Button)scene.lookup("#UserPendingBtn");
		try {
			
			
			user_pending.setOnAction(event -> {
				
				url  = getClass().getClassLoader().getResource("sample/view/fxml/usersPending.fxml");
				try {
					Root = FXMLLoader.load(url);
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				
				
				Scene sc2 = new Scene(Root, 730, 510);
				Stage newstage =  (Stage)((Node) event.getSource()).getScene().getWindow();
				newstage.setScene(sc2);
				newstage.show();
				newstage.setTitle("En attente");
				TextField username =(TextField) sc2.lookup("#txtUserName");
				username.setText(b);
				UserPendingView view=new UserPendingView();
				UserPendingView.fillTable(sc2);
				
				
				view.Dashboard(sc2,b);
				
				
				
			});
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	public void user (Scene scene,String b) {
		Button user_btn=(Button)scene.lookup("#UsersBtn");
		
		try {
			
			user_btn.setOnAction(event -> {
				
				url  = getClass().getClassLoader().getResource("sample/view/fxml/UserList.fxml");
				try {
					Root = FXMLLoader.load(url);
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				
				
				Scene sc2 = new Scene(Root, 730, 510);
				Stage newstage =  (Stage)((Node) event.getSource()).getScene().getWindow();
				newstage.setScene(sc2);
				newstage.show();
				newstage.setTitle("Utilisateurs");
				TextField username =(TextField) sc2.lookup("#txtUserName");
				username.setText(b);
				UserView view=new UserView();
				UserView.fillTable(sc2);
				
				view.Dashboard(sc2,b);
				
				
				
			});
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
}

