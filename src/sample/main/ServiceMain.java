package sample.main;
import sample.view.ServiceView;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


import java.io.IOException;
import java.lang.Exception;

public class ServiceMain extends Application {
	
	
	
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		
		try {
			Parent root = FXMLLoader.load(getClass().getResource("../view/fxml/Service.fxml"));
			primaryStage.setTitle("Services");
			Scene scene = new Scene(root, 596, 638);
			primaryStage.setScene(scene);
			primaryStage.show();
			ServiceView.fillTable(scene);
			ServiceView.add(scene);
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		
		
	}
	
	
	
	
	public static void main(String[] args) {
		launch(args);
	}
}