package sample.view;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import sample.controller.UserController;
import sample.entities.User;
import java.io.IOException;
import java.net.URL;

public class UserView {
	Parent Root;
	URL url;
	public UserView() {
	}
	
	public void BtnLogin(Scene scene) {
		Button btn;
		TextField userName;
		PasswordField password;
		Label lblStatus;
		
		try {
			UserController ctrl = new UserController();
			
			btn = (Button) scene.lookup("#btn");
			userName = (TextField) scene.lookup("#txtUserName");
			password = (PasswordField) scene.lookup("#txtPassword");
			lblStatus = (Label) scene.lookup("#lblStatus");
			btn.setOnAction(event -> {
				String u = userName.getText().toLowerCase();
				String p = password.getText();
				
				if (ctrl.sample(u, p)) {
					
					lblStatus.setText("Succès");
					User a=new User();
					
					url  = getClass().getClassLoader().getResource("sample/view/fxml/Home.fxml");
					try {
						Root = FXMLLoader.load(url);
					} catch (IOException e) {
						e.printStackTrace();
					}
					
					UserView uview = new UserView();
					String un= uview.SessionStorage(scene);
					Scene sc2=new Scene(Root,840,562);
					Stage newstage =  (Stage)((Node) event.getSource()).getScene().getWindow();
					newstage.setScene(sc2);
					newstage.setTitle("Accueil");
					newstage.show();
					TextField username =(TextField) sc2.lookup("#txtUserName");
					username.setText(un);
					String d=username.getText();
					SearchView searchView=new SearchView();
					VisitView v=new VisitView();
					v.homebtn(sc2,d);
					
					SearchView.fillCombobox(sc2);
					searchView.filltable(sc2);
					
					searchView.addVisit(sc2,d);
					searchView.logout(sc2);
					searchView.Dashboard(sc2,d);
					
					
					
				} else if (u.isEmpty() || p.isEmpty()) {
					lblStatus.setText("Cannot leave username or password blank");
					//new Alert(Alert.AlertType.ERROR, "Cannot leave username or password blank.").showAndWait();
					
				} else {
					lblStatus.setText("Login Failed, try again");
					//new Alert(Alert.AlertType.ERROR, "Login Failed, try again.").showAndWait();
				}
				
			});
			
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	
	public String SessionStorage(Scene scene){
		TextField userName = (TextField) scene.lookup("#txtUserName");
		String u = userName.getText().toLowerCase();
		return  u;
	}
	
	public void ToSignUp(Scene scene) {
		
		
		try {
			Button ToSignUp = (Button) scene.lookup("#ToSignUp");
			ToSignUp.setOnAction(event -> {
				
				url  = getClass().getClassLoader().getResource("sample/view/fxml/SignUp.fxml");
				try {
					Root = FXMLLoader.load(url);
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				
				Scene sc2 = new Scene(Root, 1000, 550);
				Stage newstage =  (Stage)((Node) event.getSource()).getScene().getWindow();
				newstage.setScene(sc2);
				newstage.show();
				SignUpView.BtnSignUp(sc2);
				SignUpView sview = new SignUpView();
				sview.toLogin(sc2);
				
				
				
				
				
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public static void fillTable (Scene scene) {
		TableView table  = (TableView) scene.lookup("#tableUser");
		Button load=(Button) scene.lookup("#LoadDataUsers");
		TableColumn<User,Integer> columnid = new TableColumn<User,Integer>("Identifiant");
		columnid.setCellValueFactory(new PropertyValueFactory("id"));
		TableColumn<User,String> columnname = new TableColumn<User,String>("Nom");
		columnname.setCellValueFactory(new PropertyValueFactory("lastName"));
		TableColumn<User,String> columnfirst = new TableColumn<User,String>("Prenom");
		columnfirst.setCellValueFactory(new PropertyValueFactory("firstName"));
		TableColumn<User,String> columnusername = new TableColumn<User,String>("username");
		columnusername.setCellValueFactory(new PropertyValueFactory("userName"));
		
		
		load.setOnAction(event ->{
			try{
				
				
				//view
				UserController controller =new UserController();
				
				table.setItems(controller.fillTable());
				table.getColumns().setAll(columnid,columnname,columnfirst,columnusername);
				table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);//don't touch this!! remove it and table gets messed up! don't know what it does tho!!!
				
			} catch (Exception e){
				e.printStackTrace();
			}
			
			
			
		});
	}
	
	public void Dashboard(Scene scene,String b){
		Button Dashboard_user=(Button)scene.lookup("#Dashboard");
		
		try {
			
			Dashboard_user.setOnAction(event -> {
				url  = getClass().getClassLoader().getResource("sample/view/fxml/Dashboard.fxml");
				try {
					Root = FXMLLoader.load(url);
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				
				
				
				
				Scene sc2 = new Scene(Root, 720, 540);
				Stage newstage =  (Stage)((Node) event.getSource()).getScene().getWindow();
				newstage.setScene(sc2);
				newstage.show();
				newstage.setTitle("Menu");
				TextField username =(TextField) sc2.lookup("#txtUserName");
				username.setText(b);
				HomeView view = new HomeView();
				view.dci(sc2,b);
				view.med(sc2,b);
				view.problem(sc2,b);
				view.service(sc2,b);
				view.patient(sc2,b);
				view.userpending(sc2,b);
				view.user(sc2,b);
				view.Home(sc2,b);
				view.intervention(sc2,b);
				
			});
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	
	
}

