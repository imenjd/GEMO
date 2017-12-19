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

            Parent Root = FXMLLoader.load(getClass().getResource("../view/fxml/Visite.fxml"));
            Scene scene = new Scene(Root, 710, 579);

            primaryStage.setScene(scene);

            primaryStage.show();

            VisitView.add(scene);
            VisitView.update(scene);
            VisitView view = new VisitView();
            view.ServiceLoad(scene);
            view.DciLoad(scene);
            view.interload(scene);
            view.patientload(scene);
            view.problemload(scene);
            view.homebtn(scene);


        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    public static void main(String[] args) {
        launch(args);
    }
}







