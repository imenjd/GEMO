package sample.view;

import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import sample.controller.ControllerSearch;
import sample.controller.VisitController;
import sample.entities.Patient;
import sample.entities.Visit;
import sample.controller.PatientController;
import sample.entities.User;

import javax.xml.soap.Text;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class PatientView {
	public PatientView() {
	}
	
	
	public  void add(Scene scene){
		Button add= (Button) scene.lookup("#add");
		final TextField fn=  (TextField) scene.lookup("#fn");
		final TextField ln= (TextField) scene.lookup("#ln");
		final DatePicker db= (DatePicker) scene.lookup("#db");
		Label label=(Label) scene.lookup("#label") ;
		
		
		add.setOnAction(event -> {
			
			String f =fn.getText();
			String l=ln.getText();
			String d=db.getValue().toString();
			
			PatientController.add(f,l,d);
			//label.setText("Added successfully !!");
			FXMLLoader Loader = new FXMLLoader(getClass().getResource("../view/fxml/Visit.fxml"));
			Parent root1 = null;
			try {
				root1 = Loader.load();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			PatientView pview = new PatientView();
			//String u=pview.SessionStorage(scene);
			
			
			Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
			stage.setTitle("Home Page");
			Scene sc2 = new Scene(root1);
			stage.setScene(sc2);
			stage.show();
			PatientController e=new PatientController();
			int val=e.SearchLastID();
			VisitController g=new VisitController();
			int val2=g.SearchLastID();
			VisitView a=new VisitView();
			a.add(sc2,val,val2);
			
			
		});
	}
	
	public  void SearchPatient(Scene scene) {
		Button search = (Button) scene.lookup("#search");
		TextField ln = (TextField) scene.lookup("#ln");
		ControllerSearch a = new ControllerSearch();
		//PatientController a=new PatientController();
		TableView searchTable = (TableView) scene.lookup("#SearchPatient");
		
		TableColumn<Patient, String> id_patient = new TableColumn<Patient, String>("Identifiant");
		id_patient.setCellValueFactory(new PropertyValueFactory<>("id"));
		TableColumn<Patient, String> last_name = new TableColumn<Patient, String>("Nom");
		last_name.setCellValueFactory(new PropertyValueFactory<>("lastName"));
		TableColumn<Patient, String> first_name = new TableColumn<Patient, String>("Prenom");
		first_name.setCellValueFactory(new PropertyValueFactory<>("firstName"));
		TableColumn<Patient, String> db = new TableColumn<Patient, String>("date de naissance");
		db.setCellValueFactory(new PropertyValueFactory<>("birthDate"));
		
		searchTable.getColumns().setAll(id_patient, last_name, first_name, db);
		searchTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		
		search.setOnAction(event -> {
			
			String l = ln.getText();
			
			searchTable.setItems(a.SearchByPatName(l));
			
			
		});
		searchTable.setRowFactory(tv -> {
			TableRow<Patient> row = new TableRow<>();
			row.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() {
				@Override
				public void handle(javafx.scene.input.MouseEvent event) {
					if(event.getClickCount() == 2 && (!row.isEmpty())) {
						int rowdata = row.getItem().getId();
						FXMLLoader Loader = new FXMLLoader(getClass().getResource("../view/fxml/Visit.fxml"));
						Parent root1 = null;
						Visit a=new Visit();
						a.setIdp(rowdata);
						try {
							root1 = Loader.load();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						PatientView pview = new PatientView();
						//String u=pview.SessionStorage(scene);
						
						
						Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
						stage.setTitle("Home Page");
						Scene sc2 = new Scene(root1);
						VisitController f=new VisitController();
						int val2=f.SearchLastID();
						stage.setScene(sc2);
						stage.show();
						VisitView b = new VisitView();
						b.add(sc2,rowdata,val2);
						
					}
					
				}
			});
			return row;
			
		});
		
		
	}
	
	
	
	
	
	
	
	public static void fillTable (Scene scene) {
		
		try{
			TableView table  = (TableView) scene.lookup("#table");
			
			//view
			PatientController controller =new PatientController();
			
			table.setItems(controller.fillTable());
			
			
			TableColumn<Patient,Integer> columnid = new TableColumn<Patient,Integer>("Identifiant");
			columnid.setCellValueFactory(new PropertyValueFactory("id"));
			TableColumn<Patient,String> columFname = new TableColumn<Patient,String>("Nom");
			columFname.setCellValueFactory(new PropertyValueFactory("lastName"));
			TableColumn<Patient,String> columnLname = new TableColumn<Patient,String>("Prenom");
			columnLname.setCellValueFactory(new PropertyValueFactory("firstName"));
			
			
			table.getColumns().setAll(columnid, columFname,columnLname);
			table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);//don't touch this!! remove it and table gets messed up! don't know what it does tho!!!
			
		} catch (Exception e){
			e.printStackTrace();
		}
		
		
		
	}
	
	
	
	
	public void homebtn(Scene scene) {
		
		try {
			Button homebtnPatient = (Button) scene.lookup("#homebtn");
			homebtnPatient.setOnAction(e -> {
				
				
				FXMLLoader Loader = new FXMLLoader(getClass().getResource("../view/fxml/Home.fxml"));
				Parent root1 = null;
				try {
					root1 = Loader.load();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				//PatientView pview = new PatientView();
				//String u=pview.SessionStorage(scene);
				UserView a=new UserView();
				
				Stage stage = (Stage)((Node) e.getSource()).getScene().getWindow();
				stage.setTitle("Home Page");
				Scene sc2 = new Scene(root1);
				stage.setScene(sc2);
				stage.show();
				
				TextField username =(TextField)sc2.lookup("#txtUserName");
				username.setText(a.SessionStorage(sc2));
				
				
				SearchView searchView=new SearchView();
				searchView.fillCombobox(sc2);
				searchView.filltable(sc2);
				
				
				searchView.addVisit(sc2);
				searchView.logout(sc2);
				searchView.Dashboard(sc2);
				
				
			});
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	public void Dashboard(Scene scene){
		try {
			Button Dashboardprob=(Button)scene.lookup("#Dashboard");
			
			Dashboardprob.setOnAction(event -> {
				
				FXMLLoader Loader = new FXMLLoader(getClass().getResource("../view/fxml/Dashboard.fxml"));
				Parent root = null;
				try {
					root =  Loader.load();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				PatientView dview = new PatientView();
				String u=dview.SessionStorage(scene);
			
				UserView a=new UserView();
				
				Scene sc2 = new Scene(root, 849, 494);
				Stage newstage =  (Stage)((Node) event.getSource()).getScene().getWindow();
				newstage.setScene(sc2);
				newstage.show();
				TextField username =(TextField)sc2.lookup("#txtUserName");
				username.setText(a.SessionStorage(sc2));
				HomeView view = new HomeView();
				view.dci(sc2);
				view.med(sc2);
				view.problem(sc2);
				view.service(sc2);
				view.userpending(sc2);
				view.user(sc2);
				view.Home(sc2);
				view.intervention(sc2);
				view.patient(sc2);
				
				
			});
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
	public String SessionStorage(Scene scene){
		TextField userName = (TextField) scene.lookup("#txtUserName");
		String u = userName.getText().toLowerCase();
		return  u;
	}
}
