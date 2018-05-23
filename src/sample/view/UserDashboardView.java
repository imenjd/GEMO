package sample.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.controller.UserController;
import sample.entities.User;

import javax.xml.soap.Text;
import java.io.IOException;



public class UserDashboardView {


	
		
		public UserDashboardView() {
		}
		
		public  static void update (Scene scene) {
		
		
		
		}
		
		
		
		public   void delete (Scene scene) {
			
			try{
				
				Button deletebutton =(Button) scene.lookup("#delete");
				Label label  = (Label) scene.lookup("#label");
				TextField id = (TextField) scene.lookup("#id");
				
				//view
				deletebutton.setOnAction(event -> {
					int d = Integer.valueOf(id.getText());//view
					
					UserController controller = new UserController() ;
					
					
					controller.delete(d);
					
					UserView.fillTable(scene);;//view
					label.setText("User Deleted Successfully!");
					
				});
				
			}catch (Exception e){
				e.printStackTrace();
				
			}
			
		}
		public void Dashboard(Scene scene,String b){
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
					UserView a=new UserView();
					
					Scene sc2 = new Scene(root, 849, 494);
					Stage newstage =  (Stage)((Node) event.getSource()).getScene().getWindow();
					newstage.setScene(sc2);
					newstage.show();
					TextField username =(TextField)sc2.lookup("#txtUserName");
					username.setText(b);
					
					HomeView view= new HomeView();
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
