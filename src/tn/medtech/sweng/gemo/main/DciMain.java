package tn.medtech.sweng.gemo.main;


import javafx.application.Application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.stage.Stage;
import tn.medtech.sweng.gemo.view.DciView;

import java.io.IOException;
import java.lang.Exception;



public class DciMain extends Application {




    @Override
    public void start(Stage primaryStage) throws Exception {


        try {
            Parent root = FXMLLoader.load(getClass().getResource("../view/fxml/Dci.fxml"));
            primaryStage.setTitle("Dci");
            Scene scene = new Scene(root, 596, 638);
            primaryStage.setScene(scene);
            primaryStage.show();
            DciView view3 = new DciView();
            view3.winInfo(scene);
            DciView.fillTable(scene);
            DciView.add(scene);
            DciView.delete(scene);
            DciView.update(scene);
            view3.Dashboard(scene);



        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void main(String[] args) {
        launch(args);
    }
}
