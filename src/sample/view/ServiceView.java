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
		
		
		
	}
	
	
	public void Dashboard(Scene scene){
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
				ServiceView dview = new ServiceView();
				String u=dview.SessionStorage(scene);
				//User a=new User();
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
		
		Label username =(Label)scene.lookup("#username");
		
		String u= username.getText();
		
		
		return  u;
	}
	
	
	
	
	
}
