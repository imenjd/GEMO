package tn.medtech.sweng.gemo.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import tn.medtech.sweng.gemo.controller.MedController;
import tn.medtech.sweng.gemo.entities.Med;

import java.io.IOException;

public class MedView {

    public void winInfo(Scene scene){

        try {
            Button btnInfo = (Button) scene.lookup("#btnInfo2");
            btnInfo.setOnAction(e -> {


                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/InfoMed.fxml"));
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

    public static void add2(Scene scene ) {


        Button btnAdd2= (Button) scene.lookup("#btnAdd2");
        TextField txtIdFirst2 = (TextField) scene.lookup("#txtIdFirst2");
        TextField txtNameFirst2 = (TextField) scene.lookup("#txtNameFirst2");
        Label txtStatusId2  = (Label) scene.lookup("#txtStatusId2");
        Label txtStatusIdN2  = (Label) scene.lookup("#txtStatusIdN2");
        TableView table2  = (TableView) scene.lookup("#tabl2e");

        btnAdd2.setOnAction(event -> {

            int d= Integer.valueOf(txtIdFirst2.getText());
            String s= txtNameFirst2.getText();
            MedController controller = new MedController() ;
            if(controller.checkId2(d)){
                txtStatusId2.setText("");
                txtStatusIdN2.setText("This ID already exists!");
            }
            else {
                controller.add2(d, s);
                txtStatusIdN2.setText("");
                txtStatusId2.setText("Med Added Successfully!");
                fillTable2(scene);

            }
        });
    }


    public  static void update2 (Scene scene ) {

        try{

            Button btnUpdate2 =(Button) scene.lookup("#btnUpdate2");
            TextField txtIdFirst2 = (TextField) scene.lookup("#txtIdFirst2");
            TextField txtNameFirst2 = (TextField) scene.lookup("#txtNameFirst2");
            Label txtStatusId2  = (Label) scene.lookup("#txtStatusId2");
            Label txtStatusIdN2  = (Label) scene.lookup("#txtStatusIdN2");
            TableView table2  = (TableView) scene.lookup("#table2");
            TextField txtIdNewFirst2 = (TextField) scene.lookup("#txtIdNewFirst2");



            btnUpdate2.setOnAction(event -> {

                int id= Integer.valueOf(txtIdFirst2.getText()) ;
                String name= txtNameFirst2.getText();
                int x = Integer.valueOf(txtIdNewFirst2.getText());

                MedController controller = new MedController() ;
                if(controller.checkId2(x)){
                    if(controller.checkId2(id) && (id!=x)) {
                        txtStatusId2.setText("");
                        txtStatusIdN2.setText("The ID already exists!");
                    }
                    else {

                        controller.update2(id, name, x);
                        fillTable2(scene);
                        txtStatusIdN2.setText("");
                        txtStatusId2.setText("Med Updated Successfully!");
                    }
                }
                else {
                    txtStatusId2.setText("");
                    txtStatusIdN2.setText("This ID does not exist!");
                }
            });




        }catch (Exception e){
            e.printStackTrace();

        }

    }



    public  static void delete2 (Scene scene) {

        try{

            Button btnDelete2 =(Button) scene.lookup("#btnDelete2");
            Label txtStatusId2  = (Label) scene.lookup("#txtStatusId2");
            Label txtStatusIdN2  = (Label) scene.lookup("#txtStatusIdN2");
            TableView table2  = (TableView) scene.lookup("#table2");
            TextField txtIdNewFirst2 = (TextField) scene.lookup("#txtIdNewFirst2");

            //view
            btnDelete2.setOnAction(event -> {
                int d = Integer.valueOf(txtIdNewFirst2.getText());//view

                MedController controller = new MedController() ;
                if(controller.checkId2(d)) {
                    controller.delete2(d);

                    fillTable2(scene);//view
                    txtStatusIdN2.setText("");
                    txtStatusId2.setText("Med Deleted Successfully!");
                }
                else {
                    txtStatusId2.setText("");
                    txtStatusIdN2.setText("This ID does not exist!");
                }
            });

        }catch (Exception e){
            e.printStackTrace();

        }

    }



    public static void fillTable2(Scene scene) {

        try{
            TableView table2  = (TableView) scene.lookup("#table2");

            //view
            MedController controller =new MedController();

            table2.setItems(controller.fillTable2());


            TableColumn<Med,Integer> columnid = new TableColumn<Med,Integer>("id");
            columnid.setCellValueFactory(new PropertyValueFactory("id"));
            TableColumn<Med,String> columnname = new TableColumn<Med,String>("Med");
            columnname.setCellValueFactory(new PropertyValueFactory("name"));

            table2.getColumns().setAll(columnid, columnname);
            table2.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        } catch (Exception e){
            e.printStackTrace();
        }



    }


    public void Dashboard(Scene scene){
        try {
            Button Dashboardmed=(Button)scene.lookup("#Dashboard");

            Dashboardmed.setOnAction(event -> {

                FXMLLoader Loader = new FXMLLoader(getClass().getResource("../view/fxml/Dashboard.fxml"));
                Parent root = null;
                try {
                    root =  Loader.load();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }

                Scene sc2 = new Scene(root);
                Stage newstage =  (Stage)((Node) event.getSource()).getScene().getWindow();
                newstage.setScene(sc2);
                newstage.show();
                DashboardView view = new DashboardView();
                view.dci(sc2);
                view.med(sc2);
                view.problem(sc2);
                view.service(sc2);
                view.service(sc2);
                view.userpending(sc2);
                view.user(sc2);
                view.Home(sc2);

            });

        } catch (Exception e) {
            e.printStackTrace();
        }



    }

}
