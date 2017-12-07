package tn.medtech.sweng.gemo.view;


import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.*;
import javafx.scene.control.cell.PropertyValueFactory;
import tn.medtech.sweng.gemo.controller.ProblemController;
import tn.medtech.sweng.gemo.entities.Problem;

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

    public static void fillTable (Scene scene) {

        try{
            TableView table  = (TableView) scene.lookup("#table");

            //view
            ProblemController controller =new ProblemController();

            table.setItems(controller.fillTable());


            TableColumn<Problem,Integer> columnid = new TableColumn<Problem,Integer>("id");
            columnid.setCellValueFactory(new PropertyValueFactory("id"));
            TableColumn<Problem,String> columnname = new TableColumn<Problem,String>("Service");
            columnname.setCellValueFactory(new PropertyValueFactory("name"));

            table.getColumns().setAll(columnid, columnname);
            table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);//don't touch this!! remove it and table gets messed up! don't know what it does tho!!!

        } catch (Exception e){
            e.printStackTrace();
        }



    }



}
