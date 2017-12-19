package tn.medtech.sweng.gemo.main;

import javafx.application.Application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.stage.Stage;
import tn.medtech.sweng.gemo.view.MedView;

import java.io.IOException;
import java.lang.Exception;



public class MedMain extends Application {




    @Override
    public void start(Stage primaryStage) throws Exception {


        try {
            Parent root = FXMLLoader.load(getClass().getResource("../view/fxml/Med.fxml"));
            primaryStage.setTitle("Med");
            Scene scene = new Scene(root, 596, 638);
            primaryStage.setScene(scene);
            primaryStage.show();
            MedView view1 = new MedView();
            view1.fillTable2(scene);
            view1.add2(scene);
            view1.delete2(scene);
            view1.update2(scene);
            view1.Dashboard(scene);
            view1.winInfo(scene);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void main(String[] args) {
        launch(args);
    }
}
