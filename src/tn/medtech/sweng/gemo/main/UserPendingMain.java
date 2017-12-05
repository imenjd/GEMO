package tn.medtech.sweng.gemo.main;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import tn.medtech.sweng.gemo.view.UserPendingView;

import java.io.IOException;

public class UserPendingMain extends Application {




    public void start(Stage primaryStage) throws Exception {


        try {
            Parent root = FXMLLoader.load(getClass().getResource("../view/fxml/UserPending.fxml"));
            primaryStage.setTitle("User Authorization");
            Scene scene = new Scene(root, 727, 450);
            primaryStage.setScene(scene);
            primaryStage.show();
            UserPendingView.fillTable(scene);
            UserPendingView.reject(scene);
            UserPendingView.accept(scene);
            UserPendingView view = new UserPendingView();
            view.winInfo(scene);
            view.UserInfo(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void main(String[] args) {
        launch(args);
    }
}

