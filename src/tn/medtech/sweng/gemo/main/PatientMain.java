package tn.medtech.sweng.gemo.main;
import javafx.application.Application;
import java.lang.Exception;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.*;

import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Main extends Application{




    @Override
    public void start(Stage primaryStage) throws Exception {
     try {
         Patient patient = new Patient();
         Parent Root = FXMLLoader.load(getClass().getResource("/com/company/javaFXpro.fxml"));
         Scene scene = new Scene(Root, 1000, 600);

         primaryStage.setScene(scene);

         primaryStage.show();

View.add(scene);
View.update(scene);

     } catch (Exception e){
             e.printStackTrace();
         }


        }


        public static void main(String[] args){
        launch(args);
        }
    }






