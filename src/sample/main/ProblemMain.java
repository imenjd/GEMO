package sample.main;
import sample.entities.Problem;
import sample.view.ProblemView;

import javafx.application.Application;


import javafx.stage.Stage;


import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;






public class ProblemMain extends Application {
	
	
	@Override
	public void start(Stage primaryStage) throws Exception{
		try {
			
			
			Problem problem = new Problem();
			Parent Root = FXMLLoader.load(getClass().getResource("../view/fxml/Problem.fxml"));
			primaryStage.setTitle("Probleme");
			Scene scene = new Scene(Root, 730, 520);
			
			primaryStage.setScene(scene);
			primaryStage.show();
			ProblemView.insert(scene);
			ProblemView.fillTable(scene);
		}catch (Exception e){
			e.printStackTrace();
		}
		
	}
	
	public static void main(String args[]) {
		
		
		launch(args);
	}
	
}