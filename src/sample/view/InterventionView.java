package sample.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import sample.controller.InterventionController;
import sample.entities.Intervention;
import java.io.*;
import java.net.URL;


public class InterventionView {
	Parent Root;
	URL url;
	public static void insert(Scene scene) {
		
		Button insert = (Button) scene.lookup("#AjoutBtn");
		TextArea name = (TextArea) scene.lookup("#MedInter");
		insert.setOnAction(event -> {
			
			String nm = name.getText();
			
			InterventionController.insert(nm);
		});
		
	}
	
	
	
	public static void fillTable (Scene scene) {
		
		Button load=(Button) scene.lookup("#LoadDataInter");
		
		load.setOnAction(event ->{
		try{
			TableView table  = (TableView) scene.lookup("#table");
			
			//view
		
			
			table.setItems(InterventionController.fillTable());
			
			
			TableColumn<Intervention,String> columnid = new TableColumn<Intervention,String>("Identifiant");
			columnid.setCellValueFactory(new PropertyValueFactory("id"));
			TableColumn<Intervention,String> columnname = new TableColumn<Intervention,String>("Nom");
			columnname.setCellValueFactory(new PropertyValueFactory("name"));
			
			table.getColumns().setAll(columnid, columnname);
			table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);//don't touch this!! remove it and table gets messed up! don't know what it does tho!!!
			
		} catch (Exception e){
			e.printStackTrace();
		}
		
		
	});
	
		
		
		
	}
	
	
	
	
	
	
	public void Dashboard(Scene scene,String b){
		Button Dashboardinter=(Button)scene.lookup("#Dashboard");
		
			
			
			Dashboardinter.setOnAction(event -> {
				try {
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
