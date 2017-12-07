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
import javafx.scene.control.cell.PropertyValueFactory;
import tn.medtech.sweng.gemo.controller.PatientController ;
import tn.medtech.sweng.gemo.entities.Patient;

public class PatientView {


    public PatientView() {
    }


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


    public static void fillTable (Scene scene) {

        try{
            TableView table  = (TableView) scene.lookup("#table");

            //view
            PatientController controller =new PatientController();

            table.setItems(controller.fillTable());


            TableColumn<Patient,Integer> columnid = new TableColumn<Patient,Integer>("id");
            columnid.setCellValueFactory(new PropertyValueFactory("id"));
            TableColumn<Patient,String> columFname = new TableColumn<Patient,String>("firstName");
            columFname.setCellValueFactory(new PropertyValueFactory("firstName"));
            TableColumn<Patient,String> columnLname = new TableColumn<Patient,String>("lastName");
            columnLname.setCellValueFactory(new PropertyValueFactory("lastName"));
            TableColumn<Patient,String> columnDate = new TableColumn<Patient,String>("birthDate");
            columnDate.setCellValueFactory(new PropertyValueFactory("birthDate"));

            table.getColumns().setAll(columnid, columFname,columnLname,columnDate );
            table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);//don't touch this!! remove it and table gets messed up! don't know what it does tho!!!

        } catch (Exception e){
            e.printStackTrace();
        }



    }



}
