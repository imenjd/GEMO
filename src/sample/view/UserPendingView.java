package sample.view;

import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.io.IOException;


import sample.entities.UserPending;
import sample.controller.UserPendingController;

import java.net.URL;

import java.util.Optional;



	
	public class UserPendingView {
		Parent Root;
		URL url;
		
		
		public static void insertDelete(int c){
			Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
			alert.setTitle("Insert or delete");
			alert.setHeaderText("Choose :");
			
			ButtonType accept = new ButtonType("Accepter");
			ButtonType delete = new ButtonType("Refuser");
			
			UserPendingController a=new UserPendingController();
			// Remove default ButtonTypes
			alert.getButtonTypes().clear();
			
			alert.getButtonTypes().addAll(accept,delete);
			
			// option != null.
			Optional<ButtonType> option = alert.showAndWait();
			
			if (option.get() == accept) {
				a.accept(c);
			} else  {
				a.reject(c);
			}
		}
		
		
		
		public static void fillTable (Scene scene) {
			TableView table  = (TableView) scene.lookup("#table");
			Button load = (Button) scene.lookup("#LoadDataUserPend");
			load.setOnAction(event -> {
						try {
							
							
							//view
							
							
							table.setItems(UserPendingController.fillTable());
							
							TableColumn<UserPending, String> columnid = new TableColumn<UserPending, String>("Identifiant");
							columnid.setCellValueFactory(new PropertyValueFactory("id"));
							TableColumn<UserPending, String> columnfirstname = new TableColumn<UserPending, String>("Prenom");
							columnfirstname.setCellValueFactory(new PropertyValueFactory("FirstName"));
							TableColumn<UserPending, String> columnlastname = new TableColumn<UserPending, String>("Nom");
							columnlastname.setCellValueFactory(new PropertyValueFactory("LastName"));
							
							TableColumn<UserPending, String> columnstatus = new TableColumn<UserPending, String>("Statut");
							columnstatus.setCellValueFactory(new PropertyValueFactory("status"));
							
							
							table.getColumns().setAll(columnid, columnfirstname, columnlastname, columnstatus);
							table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
							
						} catch (Exception e) {
							e.printStackTrace();
						}
					});
			table.setRowFactory(tv -> {
				TableRow<UserPending> row = new TableRow<>();
				row.setOnMouseClicked(new EventHandler<MouseEvent>() {
					@Override
					public void handle(javafx.scene.input.MouseEvent event) {
						if(event.getClickCount() == 2 && (!row.isEmpty())) {
							int rowdata = row.getItem().getId();
							insertDelete(rowdata);
							
						}
						
					}
				});
				return row;
				
			});
			
		}
		
		
		
		
		
		public void Dashboard(Scene scene,String b){
			
				Button Dashboarduserp=(Button)scene.lookup("#Dashboard");
				
				Dashboarduserp.setOnAction(event -> {
					try {
						
						url  = getClass().getClassLoader().getResource("sample/view/fxml/Dashboard.fxml");
						try {
							Root = FXMLLoader.load(url);
						} catch (IOException e) {
							e.printStackTrace();
						}
					
					
					
					Scene sc2 = new Scene(Root, 849, 494);
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
					view.patient(sc2,b);
					view.userpending(sc2,b);
					view.user(sc2,b);
					view.Home(sc2,b);
					view.intervention(sc2,b);
					} catch (Exception e) {
						e.printStackTrace();
						
					}
					
				});
				
			
			
			
			
		}
		
		
}
