package tn.medtech.sweng.gemo.view;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import tn.medtech.sweng.gemo.controller.ServiceController;
import tn.medtech.sweng.gemo.entities.Service;


public class ServiceView {


    Scene scene;
    //public Button addbutton= (Button) scene.lookup("#addbutton");

    public Button deletebutton = (Button) scene.lookup("#deletebutton");




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


    public  static void update (Scene scene ) {

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




}
