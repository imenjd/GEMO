package tn.medtech.sweng.gemo.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import tn.medtech.sweng.gemo.view.SearchView;
import tn.medtech.sweng.gemo.view.ServiceView;

import java.io.IOException;
import java.lang.Exception;

public class SearchMain extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        try{
            Parent root = FXMLLoader.load(getClass().getResource("../view/fxml/Home.fxml"));
            primaryStage.setTitle("Home Page");
            Scene scene=new Scene(root,710,562);
            primaryStage.setScene(scene);
            primaryStage.show();
            SearchView searchView=new SearchView();
            searchView.fillCombobox(scene);
            searchView.filltable(scene);
            searchView.getLoad(scene);
            searchView.addPatient(scene);
            searchView.addVisit(scene);



        }
        catch (IOException e) {
            e.printStackTrace();
        }


    }


    public static void main(String[] args) {
        launch(args);
    }
}
