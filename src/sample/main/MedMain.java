package sample.main;
import javafx.application.Application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.stage.Stage;

import sample.view.MedView;

import java.io.IOException;
import java.lang.Exception;

	


	
	
	
	public class MedMain extends Application {
		
		
		
		
		@Override
		public void start(Stage primaryStage) throws Exception {
			
			
			try {
				Parent root = FXMLLoader.load(getClass().getResource("../view/fxml/Medicament.fxml"));
				primaryStage.setTitle("Medicament");
				Scene scene = new Scene(root, 730, 510);
				primaryStage.setScene(scene);
				primaryStage.show();
				MedView view1 = new MedView();
				view1.fillTable2(scene);
				view1.add2(scene);
			
				view1.Dashboard(scene);
				
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			
		}
		
		public static void main(String[] args) {
			launch(args);
		}
	}

