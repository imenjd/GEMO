package sample.view;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import javafx.stage.Stage;
import java.io.IOException;
import sample.controller.ServiceController;
import sample.entities.Service;
import sample.entities.User;

public class ServiceView {
	
	
	
	public ServiceView() {
	}
	
	
	public static void add(Scene scene ) {
		
		
		Button addbutton= (Button) scene.lookup("#addbutton");

		TextArea textname = (TextArea) scene.lookup("#textname");
		
		TableView table  = (TableView) scene.lookup("#table");
		
		addbutton.setOnAction(event -> {
			
			
			String nama= textname.getText();
			
			ServiceController controller = new ServiceController();
			
		
				controller.add(nama);
				
			
				
				
				
				fillTable(scene);
			
		});
	}
	
	
	
	
	
	
	public static void fillTable (Scene scene) {
		Button load=(Button) scene.lookup("#LoadDataServices");
		
		load.setOnAction(event ->{
		try{
			TableView table  = (TableView) scene.lookup("#table");
			
			//view
			ServiceController controller =new ServiceController();
			
			table.setItems(controller.fillTable());
			
			
			TableColumn<Service,Integer> columnid = new TableColumn<Service,Integer>("id");
			columnid.setCellValueFactory(new PropertyValueFactory("id"));
			TableColumn<Service,String> columnname = new TableColumn<Service,String>("Service");
			columnname.setCellValueFactory(new PropertyValueFactory("name"));
			
			table.getColumns().setAll(columnid, columnname);
			table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);//don't touch this!! remove it and table gets messed up! don't know what it does tho!!!
			
		} catch (Exception e){
			e.printStackTrace();
		}
		
		
		
	});
	}
	
	
	public void Dashboard(Scene scene,String b){
		try {
			Button Dashboardservice=(Button)scene.lookup("#Dashboard");
			
			Dashboardservice.setOnAction(event -> {
				
				FXMLLoader Loader = new FXMLLoader(getClass().getResource("../view/fxml/Dashboard.fxml"));
				Parent root = null;
				try {
					root =  Loader.load();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
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
			});
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	
	
}
