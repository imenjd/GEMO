package sample.view;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.io.IOException;
import  sample.entities.Dci;
import sample.controller.DciController;
import sample.entities.User;



	
	
	public class DciView {
		
		
		public void winInfo(Scene scene){
			
			try {
				Button btnInfo = (Button) scene.lookup("#btnInfo");
				btnInfo.setOnAction(e -> {
					
					
					FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/InfoDci.fxml"));
					Parent root1 = null;
					try {
						root1 = (Parent) fxmlLoader.load();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					Stage stage = new Stage();
					stage.setTitle("Information");
					stage.setScene(new Scene(root1));
					stage.show();
					
				});
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		
		
		
		public static void add(Scene scene ) {
			
			
			Button btnAdd= (Button) scene.lookup("#btnAdd");
			TextField txtIdFirst = (TextField) scene.lookup("#txtIdFirst");
			TextField txtNameFirst = (TextField) scene.lookup("#txtNameFirst");
			Label txtStatusId  = (Label) scene.lookup("#txtStatusId");
			Label txtStatusIdN  = (Label) scene.lookup("#txtStatusIdN");
			
			btnAdd.setOnAction(event -> {
				
				int d= Integer.valueOf(txtIdFirst.getText());
				String s= txtNameFirst.getText();
				DciController controller = new DciController() ;
				
				if(controller.checkId(d)){
					
					txtStatusId.setText("This ID already exists!");
				}
				else {
					controller.add(d, s);
					
					txtStatusId.setText("Dci Added Successfully!");
					fillTable(scene);
					
				}
			});
		}
		
		
		public  static void update (Scene scene ) {
			
			try{
				
				Button btnUpdate =(Button) scene.lookup("#btnUpdate");
				TextField txtIdFirst = (TextField) scene.lookup("#txtIdFirst");
				TextField txtNameFirst = (TextField) scene.lookup("#txtNameFirst");
				Label txtStatusId  = (Label) scene.lookup("#txtStatusId");
				Label txtStatusIdN  = (Label) scene.lookup("#txtStatusIdN");
				TableView table  = (TableView) scene.lookup("#table");
				TextField txtIdNewFirst = (TextField) scene.lookup("#txtIdNewFirst");
				
				
				
				btnUpdate.setOnAction(event -> {
					
					int id= Integer.valueOf(txtIdFirst.getText()) ;
					String name= txtNameFirst.getText();
					int x = Integer.valueOf(txtIdNewFirst.getText());
					DciController controller = new DciController() ;
					if(controller.checkId(x)){
						if(controller.checkId(id) && (id!=x)){
							
							txtStatusId.setText("The ID already exists!");}
						else {
							
							controller.update(id, name, x);
							fillTable(scene);
							
							txtStatusId.setText("Dci Updated Successfully!");
						}
					}
					else {
						
						txtStatusId.setText("This ID does not exist!");
					}
				});
				
			}catch (Exception e){
				e.printStackTrace();
				
			}
			
		}
		
		
		
		public  static void delete (Scene scene) {
			
			try{
				
				Button btnDelete =(Button) scene.lookup("#btnDelete");
				Label txtStatusId  = (Label) scene.lookup("#txtStatusId");
				Label txtStatusIdN  = (Label) scene.lookup("#txtStatusIdN");
				TableView table  = (TableView) scene.lookup("#table");
				TextField txtIdNewFirst = (TextField) scene.lookup("#txtIdNewFirst");
				
				//view
				btnDelete.setOnAction(event -> {
					int d = Integer.valueOf(txtIdNewFirst.getText());//view
					
					DciController controller = new DciController() ;
					if(controller.checkId(d)) {
						controller.delete(d);
						
						fillTable(scene);
						
						
						txtStatusId.setText("Dci Deleted Successfully!");
						
					}
					else{
						
						txtStatusId.setText("This ID does not exist!");
					}
					
				});
				
				
			}catch (Exception e){
				e.printStackTrace();
				
			}
			
		}
		
		
		public static void fillTable (Scene scene) {
			
			try{
				TableView table  = (TableView) scene.lookup("#table");
				
				//view
				DciController controller =new DciController();
				
				table.setItems(controller.fillTable());
				
				
				TableColumn<Dci,Integer> columnid = new TableColumn<Dci,Integer>("id");
				columnid.setCellValueFactory(new PropertyValueFactory("id"));
				TableColumn<Dci,String> columnname = new TableColumn<Dci,String>("Dci");
				columnname.setCellValueFactory(new PropertyValueFactory("name"));
				
				table.getColumns().setAll(columnid, columnname);
				table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
				
			} catch (Exception e){
				e.printStackTrace();
			}
			
		}
		
		public void Dashboard(Scene scene,String b){
			Button Dashboarddci=(Button)scene.lookup("#Dashboard");
			
			try {
				
				Dashboarddci.setOnAction(event -> {
					
					FXMLLoader Loader = new FXMLLoader(getClass().getResource("../view/fxml/Dashboard.fxml"));
					Parent root = null;
					try {
						root =  Loader.load();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					//DciView dview = new DciView();
					//String u=dview.SessionStorage(scene);
					UserView a =new UserView();
					
					Scene sc2 = new Scene(root, 849, 494);
					Stage newstage =  (Stage)((Node) event.getSource()).getScene().getWindow();
					newstage.setScene(sc2);
					newstage.show();
					TextField username =(TextField) sc2.lookup("#txtUserName");
					username.setText(b);
					HomeView view = new HomeView();
					view.dci(sc2,b);
					view.med(sc2,b);
					view.problem(sc2,b);
					view.service(sc2,b);
					view.service(sc2,b);
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
