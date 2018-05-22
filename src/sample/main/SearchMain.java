package sample.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.entities.Search;
import sample.view.SearchView;
import java.io.IOException;
import java.lang.Exception;

public class SearchMain extends Application {
	
	@Override
	public void start(Stage primaryStage) throws Exception{
		try{
			Parent root = FXMLLoader.load(getClass().getResource("../view/fxml/Home.fxml"));
			primaryStage.setTitle("Home Page");
			Scene scene=new Scene(root,840,562);
			primaryStage.setScene(scene);
			primaryStage.show();
			SearchView searchView=new SearchView();
			searchView.fillCombobox(scene);
			searchView.filltable(scene);
			
			
			searchView.addVisit(scene);
			searchView.logout(scene);
			searchView.Dashboard(scene);
			
			
			
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
}