package tn.medtech.sweng.gemo.main;

import javafx.application.Application;

import java.lang.Exception;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.stage.Stage;
import tn.medtech.sweng.gemo.entities.Visit;
import tn.medtech.sweng.gemo.view.VisitView;

public class VisitMain extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            Visit visit = new Visit();
            Parent Root = FXMLLoader.load(getClass().getResource("../view/fxml/Visit.fxml"));
            Scene scene = new Scene(Root, 1000, 600);

            primaryStage.setScene(scene);

            primaryStage.show();

            VisitView.add(scene);
            VisitView.update(scene);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    public static void main(String[] args) {
        launch(args);
    }
}







