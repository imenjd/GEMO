package tn.medtech.sweng.gemo.main;

import javafx.application.Application;


import javafx.stage.Stage;


import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;



import tn.medtech.sweng.gemo.entities.Problem;
import tn.medtech.sweng.gemo.view.ProblemView;


public class ProblemMain extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception{
        try {


            Problem problem = new Problem();
            Parent Root = FXMLLoader.load(getClass().getResource("../view/fxml/ProblemFx.fxml"));
            Scene scene = new Scene(Root, 1000, 600);

            primaryStage.setScene(scene);
            primaryStage.show();
            ProblemView.insert(scene);
            ProblemView.update(scene);
            ProblemView.delete(scene);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void main(String args[]) {


        launch(args);
    }

}
