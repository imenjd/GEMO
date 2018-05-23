package sample.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import sample.controller.ControllerSearch;
import sample.controller.PatientController;
import sample.entities.Patient;
import sample.entities.Visit;
import sample.controller.VisitController;
import sample.entities.User;


import javax.xml.soap.Text;
import java.io.IOException;

public class VisitView {
	public VisitView() {
	}
	
	
	public void add(Scene scene, int id,int idvisite1) {
		
		Button add = (Button) scene.lookup("#add");
		TextField idp = (TextField) scene.lookup("#idpatient");
		TextField idv = (TextField) scene.lookup("#IdVis");
		TextArea comment = (TextArea) scene.lookup("#commentaire");
		TextArea context = (TextArea) scene.lookup("#contexte");
		TextField serviice = (TextField) scene.lookup("#Service");
		DatePicker date = (DatePicker) scene.lookup("#dateVisit");
	;
		TextField dci = (TextField) scene.lookup("#Dci");
		ComboBox inte = (ComboBox) scene.lookup("#Inter");
		
		ComboBox prob = (ComboBox) scene.lookup("#Probleme");
		ComboBox med = (ComboBox) scene.lookup("#med");
		TextField username =(TextField) scene.lookup("#username");
		Patient c=new Patient ();
		idp.setText(String.valueOf(id));
		idv.setText(String.valueOf(idvisite1));
		ControllerSearch a = new ControllerSearch();
		VisitController b=new VisitController();
		ObservableList<String> fill_problem = a.fillProblemlist();
		ObservableList<String> fill_inter = a.fillInterlit();
		ObservableList<String> fill_med = a.fillMedlist();
		
		inte.setItems(fill_inter);
		prob.setItems(fill_problem);
		med.setItems(fill_med);
			
			
			
			
			try {
			
			
			add.setOnAction(event -> {
				
				
				String idpat =idp.getText() ;
				
				String date1 = date.getValue().toString();
				String comment1 = comment.getText();
				String context1 = context.getText();
				String idvisite = idv.getText();
				String serviiice=serviice.getText();
				String intervention=inte.getValue().toString();
				String dciii=dci.getText();
				String probleme=prob.getValue().toString();
				String medicament=med.getValue().toString();
				String u=username.getText();
				VisitController ctrrl = new VisitController();
				
				ctrrl.add(u,idpat,date1,serviiice,dciii,intervention,probleme,medicament,context1,comment1);
				
				
				
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public void homebtn(Scene scene,String b) {
		Button homebtn = (Button) scene.lookup("#Home");
		try {
			
			homebtn.setOnAction(e -> {
				
				
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/fxml/Home.fxml"));
				Parent root1 = null;
				try {
					root1 = fxmlLoader.load();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				UserView a=new UserView();
				
				
				Stage stage = (Stage)((Node) e.getSource()).getScene().getWindow();
				stage.setTitle("Home Page");
				Scene sc2 = new Scene(root1);
				stage.setScene(sc2);
				stage.show();
				TextField username =(TextField) sc2.lookup("#txtUserName");
				username.setText(b);
				SearchView searchView=new SearchView();
				searchView.fillCombobox(sc2);
				searchView.filltable(sc2);
				searchView.addVisit(sc2,b);
				searchView.logout(sc2);
				searchView.Dashboard(sc2,b);
				
				
			});
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
}




