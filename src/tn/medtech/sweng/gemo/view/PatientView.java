package tn.medtech.sweng.gemo.view;

import javafx.application.Application;
import java.lang.Exception;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.*;
import tn.medtech.sweng.gemo.controller.PatientController ;

public class PatientView {
    Scene scene;


    public static void add(Scene scene){
        Button add= (Button) scene.lookup("#add");
        final TextField fn=  (TextField) scene.lookup("#fn");
        final TextField ln= (TextField) scene.lookup("#ln");
        final DatePicker db= (DatePicker) scene.lookup("#db");
        Label label=(Label) scene.lookup("#label") ;


        add.setOnAction(event -> {

            String f =fn.getText();
            String l=ln.getText();
            String d=db.getValue().toString();

            PatientController.add(f,l,d);
            label.setText("Added successfully !!");


        });
    }
    public static void update(Scene scene){

        Button update=(Button) scene.lookup("#update");
        TextField fn= (TextField) scene.lookup("#fn");
        TextField ln=(TextField) scene.lookup("#ln");
        DatePicker db=  (DatePicker) scene.lookup("#db");
        TextField id=(TextField) scene.lookup("#id");
        Label label=(Label) scene.lookup("#label") ;
        update.setOnAction(event -> {

            try {

                String f =fn.getText();
                String l=ln.getText();
                String d=db.getValue().toString();


                int idd = Integer.valueOf(id.getText());
                if (PatientController.exist(idd)) {
                    PatientController.update(f,l,d, idd);
                    label.setText("Updated successfully !!");
                }else {
                    label.setText("this ID doesn't exist !!");

                }
            }catch (Exception e){
                e.printStackTrace();
            }
        });
    }
}
