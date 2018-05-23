package sample.view;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class PreVisiteVIew {
	
	public  void choose (Scene scene,String d){
		Button newpatient=(Button) scene.lookup("#new");
		Button olpatient=(Button) scene.lookup("#old");
		
		
		
		//Button addVisit=(Button)scene.lookup("#addVisit");
		
		newpatient.setOnAction(event -> {
			
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/fxml/Patient.fxml"));
			Parent root = null;
			try {
				root =  fxmlLoader.load();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
			
			Scene sc2 = new Scene(root);
			TextField username =(TextField)sc2.lookup("#username");
			username.setText(d);
			Stage newstage =  (Stage)((Node) event.getSource()).getScene().getWindow();
			newstage.setScene(sc2);
			newstage.show();
			PatientView a=new PatientView();
			a.add(sc2,d);
			a.homebtn(sc2,d);
		
			
		} );
		
		
		
		
		olpatient.setOnAction(event -> {
			FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("../view/fxml/Ancien.fxml"));
			Parent root1 = null;
			try {
				root1 =  fxmlLoader1.load();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			;
			
			
			Scene sc3 = new Scene(root1);
			TextField username =(TextField)sc3.lookup("#username");
			username.setText(d);
			Stage newstage =  (Stage)((Node) event.getSource()).getScene().getWindow();
			newstage.setScene(sc3);
			newstage.show();
			PatientView b=new PatientView();
			b.SearchPatient(sc3,d);
			b.homebtn(sc3,d);
			
		});
		
	}

}
