package tn.medtech.sweng.gemo.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import tn.medtech.sweng.gemo.view.ServiceView;

import java.io.IOException;
import java.lang.Exception;

public class ServiceMain extends Application {





    @Override
    public void start(Stage primaryStage) throws Exception {


        try {
            Parent root = FXMLLoader.load(getClass().getResource("../view/fxml/services.fxml"));
            primaryStage.setTitle("SERVICES");
            Scene scene = new Scene(root, 596, 638);
            primaryStage.setScene(scene);
            primaryStage.show();
            ServiceView.fillTable(scene);
            ServiceView.add(scene);
            ServiceView.delete(scene);
            ServiceView.update(scene);



        } catch (IOException e) {
            e.printStackTrace();
        }





    }




    public static void main(String[] args) {
        launch(args);
    }
}
