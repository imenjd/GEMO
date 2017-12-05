package tn.medtech.sweng.gemo.main;

import javafx.application.Application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.Button;
import javafx.stage.Stage;
import tn.medtech.sweng.gemo.view.MedView;

import java.io.IOException;
import java.lang.Exception;



public class MedMain extends Application {




    @Override
    public void start(Stage primaryStage) throws Exception {


        try {
            Parent root = FXMLLoader.load(getClass().getResource("../view/Med.fxml"));
            primaryStage.setTitle("Med");
            Scene scene = new Scene(root, 266, 563);
            primaryStage.setScene(scene);
            primaryStage.show();
            MedView.fillTable2(scene);
            MedView.add2(scene);
            MedView.delete2(scene);
            MedView.update2(scene);
            MedView view1 = new MedView();
            view1.winInfo(scene);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void main(String[] args) {
        launch(args);
    }
}
