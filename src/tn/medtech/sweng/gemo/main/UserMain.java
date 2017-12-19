package tn.medtech.sweng.gemo.main;
import tn.medtech.sweng.gemo.view.SignUpView;
import tn.medtech.sweng.gemo.view.UserView;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


import java.io.IOException;


public  class UserMain extends Application {

    Parent Root;
    @Override
    public void start(Stage primaryStage)throws Exception  {
        try {
            Root = FXMLLoader.load(getClass().getResource("../view/fxml/Login.fxml"));

            Scene scene = new Scene(Root, 1000, 550);
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



