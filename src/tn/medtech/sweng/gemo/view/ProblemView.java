package tn.medtech.sweng.gemo.view;


import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.*;
import tn.medtech.sweng.gemo.controller.ProblemController;

public class ProblemView {

    public static void insert(Scene scene){

        Button insert = (Button) scene.lookup("#insert");
        TextField name = (TextField) scene.lookup("#name");
        insert.setOnAction(event -> {

            String nm=name.getText();

            ProblemController.insert(nm);
        });

    }
    public static void update(Scene scene){
        Button update = (Button) scene.lookup("#update");
        TextField name = (TextField) scene.lookup("#name");
        TextField id = (TextField) scene.lookup("#id");
        update.setOnAction(event -> {

            String nm;
            nm=name.getText();
            int d = Integer.valueOf(id.getText());
            ProblemController.update(nm, d);
        });

    }
    public static void delete(Scene scene){
        Button  delete = (Button) scene.lookup("#delete");
        TextField id = (TextField) scene.lookup("#id");

        delete.setOnAction(event -> {

            int d = Integer.valueOf(id.getText());
            ProblemController.delete(d);
        });

    }
}
