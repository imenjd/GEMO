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
import sample.entities.User;

public class InterventionView {
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
			InterventionController controller =new InterventionController();
			
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
	public String SessionStorage(Scene scene){
		TextField userName = (TextField) scene.lookup("#txtUserName");
		String u = userName.getText().toLowerCase();
		return  u;
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
				InterventionView dview = new InterventionView();
				String u=dview.SessionStorage(scene);
				UserView a=new UserView();
				
				Scene sc2 = new Scene(root, 849, 494);
				Stage newstage =  (Stage)((Node) event.getSource()).getScene().getWindow();
				newstage.setScene(sc2);
				newstage.show();
				TextField username =(TextField) sc2.lookup("#txtUserName");
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
	
	
}
