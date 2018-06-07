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

import sample.controller.PatientController;

import java.io.IOException;
import java.net.URL;

public class PatientView {
	Parent Root;
	URL url;
	public PatientView() {
	}
	
	
	public  void add(Scene scene,String b){
		Button add= (Button) scene.lookup("#add");
		final TextField fn=  (TextField) scene.lookup("#fn");
		final TextField ln= (TextField) scene.lookup("#ln");
		final DatePicker db= (DatePicker) scene.lookup("#db");
		
		
		
		add.setOnAction(event -> {
			
			String f =fn.getText();
			String l=ln.getText();
			String d=db.getValue().toString();
			
			PatientController.add(f,l,d);
			
			FXMLLoader Loader = new FXMLLoader(getClass().getResource("../view/fxml/Visit.fxml"));
			Parent root1 = null;
			try {
				root1 = Loader.load();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
			
			
			Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
			stage.setTitle("Visite");
			Scene sc2 = new Scene(root1);
			
			TextField username =(TextField)sc2.lookup("#txtUserName");
			username.setText(b);
			stage.setScene(sc2);
			stage.show();
			PatientController e=new PatientController();
			int val=e.SearchLastID();
			VisitController g=new VisitController();
			int val2=g.SearchLastID();
			VisitView a=new VisitView();
			a.add(sc2,val,val2);
			a.homebtn(sc2,b);
			
			
			
		});
	}
	
	public  void SearchPatient(Scene scene,String b) {
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
						
						url  = getClass().getClassLoader().getResource("sample/view/fxml/Visit.fxml");
						try {
							Root = FXMLLoader.load(url);
						} catch (IOException e) {
							e.printStackTrace();
						}
						
						
						
						
						Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
						stage.setTitle("Visite");
						Scene sc2 = new Scene(Root);
						
						TextField username =(TextField)sc2.lookup("#txtUserName");
						username.setText(b);
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
		Button load=(Button) scene.lookup("#LoadPatient");
		
		load.setOnAction(event ->{
		try{
			TableView table  = (TableView) scene.lookup("#table");
	
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
		
		
		
	});
	}
	
	
	
	
	public void homebtn(Scene scene, String b) {
		Button homebtnPatient = (Button) scene.lookup("#Home");
		try {
			
			homebtnPatient.setOnAction(e -> {
				
				url  = getClass().getClassLoader().getResource("sample/view/fxml/Home.fxml");
				try {
					Root = FXMLLoader.load(url);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				
				
				
			
				
				Stage stage = (Stage)((Node) e.getSource()).getScene().getWindow();
				stage.setTitle("Accueil");
				Scene sc2 = new Scene(Root);
				stage.setScene(sc2);
				stage.show();
				
				TextField username =(TextField)sc2.lookup("#txtUserName");
				username.setText(b);
				
				
				SearchView searchView=new SearchView();
				SearchView.fillCombobox(sc2);
				searchView.filltable(sc2);
				
				
				searchView.addVisit(sc2,b);
				searchView.logout(sc2);
				searchView.Dashboard(sc2,b);
				
				
			});
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	public void Dashboard(Scene scene,String b){
		Button Dashboardpat=(Button)scene.lookup("#Dashboard");
		
			
			
			Dashboardpat.setOnAction(event -> {
				try {
					
					url  = getClass().getClassLoader().getResource("sample/view/fxml/Dashboard.fxml");
					try {
						Root = FXMLLoader.load(url);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					
					
				
				Scene sc2 = new Scene(Root, 720, 540);
				Stage newstage =  (Stage)((Node) event.getSource()).getScene().getWindow();
				newstage.setScene(sc2);
				newstage.show();
					newstage.setTitle("Menu");
				TextField username =(TextField)sc2.lookup("#txtUserName");
				username.setText(b);
				HomeView view = new HomeView();
				view.dci(sc2,b);
				view.med(sc2,b);
				view.problem(sc2,b);
				view.service(sc2,b);
				view.userpending(sc2,b);
				view.user(sc2,b);
				view.Home(sc2,b);
				view.intervention(sc2,b);
				view.patient(sc2,b);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				
			});
			
		
		
		
		
	}
	
}
