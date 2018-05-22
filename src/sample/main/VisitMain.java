package sample.main;
import  sample.view.VisitView;
import javafx.application.Application;

import java.lang.Exception;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.stage.Stage;


public class VisitMain extends Application {
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			
			Parent Root = FXMLLoader.load(getClass().getResource("../view/fxml/Visit.fxml"));
			primaryStage.setTitle("Visite");
			Scene scene = new Scene(Root, 600, 579);
			
			primaryStage.setScene(scene);
			
			primaryStage.show();
			VisitView view = new VisitView();
			//view.add(scene);
			
			
			//view.homebtn(scene);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	
}

