package tn.medtech.sweng.gemo.view;


import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import tn.medtech.sweng.gemo.controller.DciController;
import tn.medtech.sweng.gemo.entities.Dci;

import java.io.IOException;


public class DciView {


    public void winInfo(Scene scene){

        try {
            Button btnInfo = (Button) scene.lookup("#btnInfo");
            btnInfo.setOnAction(e -> {


                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/InfoDci.fxml"));
                Parent root1 = null;
                try {
                    root1 = (Parent) fxmlLoader.load();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                Stage stage = new Stage();
                stage.setTitle("Information");
                stage.setScene(new Scene(root1));
                stage.show();

            });
        } catch(Exception e) {
            e.printStackTrace();
        }
    }




    public static void add(Scene scene ) {


        Button btnAdd= (Button) scene.lookup("#btnAdd");
        TextField txtIdFirst = (TextField) scene.lookup("#txtIdFirst");
        TextField txtNameFirst = (TextField) scene.lookup("#txtNameFirst");
        Label txtStatusId  = (Label) scene.lookup("#txtStatusId");
        Label txtStatusIdN  = (Label) scene.lookup("#txtStatusIdN");

        btnAdd.setOnAction(event -> {

            int d= Integer.valueOf(txtIdFirst.getText());
            String s= txtNameFirst.getText();
            DciController controller = new DciController() ;

            if(controller.checkId(d)){
                txtStatusId.setText("");
                txtStatusIdN.setText("This ID already exists!");
            }
            else {
                controller.add(d, s);
                txtStatusIdN.setText("");
                txtStatusId.setText("Dci Added Successfully!");
                fillTable(scene);

            }
        });
    }


    public  static void update (Scene scene ) {

        try{

            Button btnUpdate =(Button) scene.lookup("#btnUpdate");
            TextField txtIdFirst = (TextField) scene.lookup("#txtIdFirst");
            TextField txtNameFirst = (TextField) scene.lookup("#txtNameFirst");
            Label txtStatusId  = (Label) scene.lookup("#txtStatusId");
            Label txtStatusIdN  = (Label) scene.lookup("#txtStatusIdN");
            TableView table  = (TableView) scene.lookup("#table");
            TextField txtIdNewFirst = (TextField) scene.lookup("#txtIdNewFirst");



            btnUpdate.setOnAction(event -> {

                int id= Integer.valueOf(txtIdFirst.getText()) ;
                String name= txtNameFirst.getText();
                int x = Integer.valueOf(txtIdNewFirst.getText());
                DciController controller = new DciController() ;
                if(controller.checkId(x)){
                    if(controller.checkId(id) && (id!=x)){
                        txtStatusId.setText("");
                        txtStatusIdN.setText("The ID already exists!");}
                    else {

                        controller.update(id, name, x);
                        fillTable(scene);
                        txtStatusIdN.setText("");
                        txtStatusId.setText("Dci Updated Successfully!");
                    }
                }
                else {
                    txtStatusId.setText("");
                    txtStatusIdN.setText("This ID does not exist!");
                }
            });

        }catch (Exception e){
            e.printStackTrace();

        }

    }



    public  static void delete (Scene scene) {

        try{

            Button btnDelete =(Button) scene.lookup("#btnDelete");
            Label txtStatusId  = (Label) scene.lookup("#txtStatusId");
            Label txtStatusIdN  = (Label) scene.lookup("#txtStatusIdN");
            TableView table  = (TableView) scene.lookup("#table");
            TextField txtIdNewFirst = (TextField) scene.lookup("#txtIdNewFirst");

            //view
            btnDelete.setOnAction(event -> {
                int d = Integer.valueOf(txtIdNewFirst.getText());//view

                DciController controller = new DciController() ;
                if(controller.checkId(d)) {
                    controller.delete(d);

                    fillTable(scene);

                    txtStatusIdN.setText("");
                    txtStatusId.setText("Dci Deleted Successfully!");

                }
                else{
                    txtStatusId.setText("");
                    txtStatusIdN.setText("This ID does not exist!");
                }

            });


        }catch (Exception e){
            e.printStackTrace();

        }

    }


    public static void fillTable (Scene scene) {

        try{
            TableView table  = (TableView) scene.lookup("#table");

            //view
            DciController controller =new DciController();

            table.setItems(controller.fillTable());


            TableColumn<Dci,Integer> columnid = new TableColumn<Dci,Integer>("id");
            columnid.setCellValueFactory(new PropertyValueFactory("id"));
            TableColumn<Dci,String> columnname = new TableColumn<Dci,String>("Dci");
            columnname.setCellValueFactory(new PropertyValueFactory("name"));

            table.getColumns().setAll(columnid, columnname);
            table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        } catch (Exception e){
            e.printStackTrace();
        }

    }


}