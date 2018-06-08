package sample.main;
import sample.view.UserView;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.net.URL;


import java.io.IOException;


public  class UserMain extends Application {
	
	Parent Root;
	URL url;
	@Override
	public void start(Stage primaryStage)throws Exception  {
		
		try {
			
			url  = getClass().getClassLoader().getResource("sample/view/fxml/SignIn.fxml");
			Root = FXMLLoader.load(url);
			
			Scene scene = new Scene(Root, 1000, 550);
			primaryStage.setTitle("Connexion");
			primaryStage.setScene(scene);
			primaryStage.show();
			
			UserView view = new UserView();
			view.BtnLogin(scene);
			view.ToSignUp(scene);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		
		launch(args);
	}
}
