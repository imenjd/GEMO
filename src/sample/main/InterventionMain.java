package sample.main;
import javafx.application.Application;

import java.lang.Exception;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.stage.Stage;
import sample.entities.Intervention;
import sample.view.InterventionView;


	
	
	
	public class InterventionMain extends Application {
		
		
		@Override
		public void start(Stage primaryStage) throws Exception {
			try {
				
				
				Intervention intervention = new Intervention();
				Parent Root = FXMLLoader.load(getClass().getResource("../view/fxml/Intervention.fxml"));
				Scene scene = new Scene(Root, 730, 510);
				primaryStage.setTitle("Intervention");
				primaryStage.setScene(scene);
				primaryStage.show();
				InterventionView.insert(scene);
				InterventionView.fillTable(scene);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		public static void main(String args[]) {
			
			
			launch(args);
		}
		
	}

