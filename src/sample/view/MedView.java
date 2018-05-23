package sample.view;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.io.*;
import sample.controller.MedController;
import sample.entities.Med;
import sample.entities.User;

import javax.xml.soap.Text;

public class MedView {
	
	public static void add2(Scene scene ) {
		
		
		Button btnAdd2= (Button) scene.lookup("#AjoutBtn1");
		TextArea txtNameFirst2 = (TextArea) scene.lookup("#MedName");
		btnAdd2.setOnAction(event -> {
			
			String s= txtNameFirst2.getText();
			MedController controller = new MedController() ;
			controller.add2(s);
			fillTable2(scene);
				
			
		});
	}
	
	
	
	
	
	
	public static void fillTable2(Scene scene) {
		Button load=(Button) scene.lookup("#LoadDataMed");
		
		load.setOnAction(event ->{
			try{
				TableView table2  = (TableView) scene.lookup("#table2");
			
			//view
				MedController controller =new MedController();
			
				table2.setItems(controller.fillTable2());
			
			
				TableColumn<Med,String> columnid = new TableColumn<Med,String>("Identifiant");
				columnid.setCellValueFactory(new PropertyValueFactory("id"));
				TableColumn<Med,String> columnname = new TableColumn<Med,String>("Nom");
				columnname.setCellValueFactory(new PropertyValueFactory("name"));
			
				table2.getColumns().setAll(columnid, columnname);
				table2.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
			
			} catch (Exception e){
				e.printStackTrace();
			}
		
		
		
		});
	}
	
	public void Dashboard(Scene scene,String b){
		Button Dashboardmed=(Button)scene.lookup("#Dashboard");
		
			
			
			Dashboardmed.setOnAction(event -> {
				try {
				
				FXMLLoader Loader = new FXMLLoader(getClass().getResource("../view/fxml/Dashboard.fxml"));
				Parent root = null;
				try {
					root =  Loader.load();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				MedView dview = new MedView();
				
				UserView a=new UserView();
				
				Scene sc2 = new Scene(root, 849, 494);
				Stage newstage =  (Stage)((Node) event.getSource()).getScene().getWindow();
				newstage.setScene(sc2);
				newstage.show();
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
	
	
