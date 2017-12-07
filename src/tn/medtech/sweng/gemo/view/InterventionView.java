package tn.medtech.sweng.gemo.view;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import tn.medtech.sweng.gemo.controller.InterventionController;
import tn.medtech.sweng.gemo.controller.ServiceController;
import tn.medtech.sweng.gemo.entities.Intervention;
import tn.medtech.sweng.gemo.entities.Service;

public class InterventionView {

    public static void insert(Scene scene) {

        Button insert = (Button) scene.lookup("#insert");
        TextField name = (TextField) scene.lookup("#name");
        insert.setOnAction(event -> {

            String nm = name.getText();

            InterventionController.insert(nm);
        });

    }

    public static void update(Scene scene) {
        Button update = (Button) scene.lookup("#update");
        TextField name = (TextField) scene.lookup("#name");
        TextField id = (TextField) scene.lookup("#id");
        update.setOnAction(event -> {

            String nm;
            nm = name.getText();
            int d = Integer.valueOf(id.getText());
            InterventionController.update(nm, d);
        });

    }

    public static void delete(Scene scene) {
        Button delete = (Button) scene.lookup("#delete");
        TextField id = (TextField) scene.lookup("#id");

        delete.setOnAction(event -> {

            int d = Integer.valueOf(id.getText());
            InterventionController.delete(d);
        });

    }


    public static void fillTable (Scene scene) {

        try{
            TableView table  = (TableView) scene.lookup("#table");

            //view
            InterventionController controller =new InterventionController();

            table.setItems(InterventionController.fillTable());


            TableColumn<Intervention,Integer> columnid = new TableColumn<Intervention,Integer>("id");
            columnid.setCellValueFactory(new PropertyValueFactory("id"));
            TableColumn<Intervention,String> columnname = new TableColumn<Intervention,String>("Service");
            columnname.setCellValueFactory(new PropertyValueFactory("name"));

            table.getColumns().setAll(columnid, columnname);
            table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);//don't touch this!! remove it and table gets messed up! don't know what it does tho!!!

        } catch (Exception e){
            e.printStackTrace();
        }



    }

}

