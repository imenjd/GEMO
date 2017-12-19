package tn.medtech.sweng.gemo.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import tn.medtech.sweng.gemo.controller.ServiceController;
import tn.medtech.sweng.gemo.entities.Service;

import java.io.IOException;


public class ServiceView {




    public ServiceView() {
    }


    public static void add(Scene scene ) {


        Button addbutton= (Button) scene.lookup("#addbutton");
        TextField textid = (TextField) scene.lookup("#textid");
        TextField textname = (TextField) scene.lookup("#textname");
        Label checklabel  = (Label) scene.lookup("#checklabel");

        TableView table  = (TableView) scene.lookup("#table");

        addbutton.setOnAction(event -> {

            int d= Integer.valueOf(textid.getText());
            String nama= textname.getText();

            ServiceController controller = new ServiceController();

            if(controller.checkId(d)){
                checklabel.setText("this id already exists!");
            }
            else {
                controller.add(d, nama);

                checklabel.setText("Service Added Successfully!");



                fillTable(scene);
            }
        });
    }


    public  static void update (Scene scene) {

        try{

            Button updatebutton =(Button) scene.lookup("#updatebutton");
            TextField textid = (TextField) scene.lookup("#textid");
            TextField textname = (TextField) scene.lookup("#textname");
            Label checklabel  = (Label) scene.lookup("#checklabel");
            TextField extratxt = (TextField) scene.lookup("#extratxt");



            updatebutton.setOnAction(event -> {

                int id= Integer.valueOf(textid.getText()) ;
                String name= textname.getText();
                int x = Integer.valueOf(extratxt.getText());

                ServiceController controller = new ServiceController() ;

                if(controller.checkId(x)){
                    if(controller.checkId(id) && (id!=x))
                        checklabel.setText("The id already exists!");
                    else {

                        controller.update(id, name, x);

                        fillTable(scene);

                        checklabel.setText("Service Updated Successfully!");
                    }
                }
                else
                    checklabel.setText("this id does not exist!");


            });




        }catch (Exception e){
            e.printStackTrace();

        }

    }



    public  static void delete (Scene scene) {

        try{

            Button deletebutton =(Button) scene.lookup("#deletebutton");
            Label checklabel  = (Label) scene.lookup("#checklabel");
            TextField extratxt = (TextField) scene.lookup("#extratxt");

            //view
            deletebutton.setOnAction(event -> {
                int d = Integer.valueOf(extratxt.getText());//view

                ServiceController controller = new ServiceController() ;

                if(controller.checkId(d)) {
                    controller.delete(d);

                    fillTable(scene);//view
                    checklabel.setText("Service Deleted Successfully!");

                }
                else
                    checklabel.setText("this id does not exist!");
            });

        }catch (Exception e){
            e.printStackTrace();

        }

    }



    public static void fillTable (Scene scene) {

        try{
            TableView table  = (TableView) scene.lookup("#table");

            //view
            ServiceController controller =new ServiceController();

            table.setItems(controller.fillTable());


            TableColumn<Service,Integer> columnid = new TableColumn<Service,Integer>("id");
            columnid.setCellValueFactory(new PropertyValueFactory("id"));
            TableColumn<Service,String> columnname = new TableColumn<Service,String>("Service");
            columnname.setCellValueFactory(new PropertyValueFactory("name"));

            table.getColumns().setAll(columnid, columnname);
            table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);//don't touch this!! remove it and table gets messed up! don't know what it does tho!!!

        } catch (Exception e){
            e.printStackTrace();
        }



    }


    public void Dashboard(Scene scene){
        try {
            Button Dashboardservice=(Button)scene.lookup("#Dashboard");

            Dashboardservice.setOnAction(event -> {

                FXMLLoader Loader = new FXMLLoader(getClass().getResource("../view/fxml/Dashboard.fxml"));
                Parent root = null;
                try {
                    root =  Loader.load();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                ServiceView dview = new ServiceView();
                String u=dview.SessionStorage(scene);

                Scene sc2 = new Scene(root, 849, 494);
                Stage newstage =  (Stage)((Node) event.getSource()).getScene().getWindow();
                newstage.setScene(sc2);
                newstage.show();
                Label username =(Label)sc2.lookup("#username");
                username.setText(u);
                DashboardView view = new DashboardView();
                view.dci(sc2);
                view.med(sc2);
                view.problem(sc2);
                view.service(sc2);
                view.service(sc2);
                view.userpending(sc2);
                view.user(sc2);
                view.Home(sc2);
                view.intervention(sc2);
            });

        } catch (Exception e) {
            e.printStackTrace();
        }



    }


    public String SessionStorage(Scene scene){

        Label username =(Label)scene.lookup("#username");

        String u= username.getText();


        return  u;
    }




    public void winInfo(Scene scene){

        try {
            Button btnInfo = (Button) scene.lookup("#info");
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



}
