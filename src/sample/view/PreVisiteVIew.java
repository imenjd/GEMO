package sample.view;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;

import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class PreVisiteVIew {
	
	public  void choose (Scene scene){
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
			SearchView sview = new SearchView();
			//String u=sview.SessionStorage(scene);
			
			Scene sc2 = new Scene(root);
			Stage newstage =  (Stage)((Node) event.getSource()).getScene().getWindow();
			newstage.setScene(sc2);
			newstage.show();
			PatientView a=new PatientView();
			VisitView b=new VisitView();
			a.add(sc2);
			b.homebtn(sc2);
			//b.SessionStorage(sc2);
			
		} );
		
		
		
		
		olpatient.setOnAction(event -> {
			FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("../view/fxml/Ancien.fxml"));
			Parent root1 = null;
			try {
				root1 =  fxmlLoader1.load();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			SearchView sview = new SearchView();
			//String u=sview.SessionStorage(scene);
			
			Scene sc3 = new Scene(root1);
			Stage newstage =  (Stage)((Node) event.getSource()).getScene().getWindow();
			newstage.setScene(sc3);
			newstage.show();
			PatientView b=new PatientView();
			b.SearchPatient(sc3);
			
		});
		
	}

}
