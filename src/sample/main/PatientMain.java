package sample.main;

import javafx.application.Application;

import java.lang.Exception;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.stage.Stage;
import sample.view.PatientView;

public class PatientMain extends Application {
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			Parent Root = FXMLLoader.load(getClass().getResource("../view/fxml/Patient.fxml"));
			primaryStage.setTitle("Patient");
			Scene scene = new Scene(Root, 600, 300);
			primaryStage.setScene(scene);
			
			primaryStage.show();
			PatientView viewP = new PatientView();
			viewP.add(scene);
			
			viewP.homebtn(scene);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
