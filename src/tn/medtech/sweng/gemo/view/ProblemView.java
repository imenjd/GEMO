package tn.medtech.sweng.gemo.view;


import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import tn.medtech.sweng.gemo.controller.ProblemController;
import tn.medtech.sweng.gemo.entities.Problem;

import java.io.IOException;

public class ProblemView {

    public ProblemView() {
    }

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
            TableColumn<Problem,String> columnname = new TableColumn<Problem,String>("Problem");
            columnname.setCellValueFactory(new PropertyValueFactory("name"));

            table.getColumns().setAll(columnid, columnname);
            table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);//don't touch this!! remove it and table gets messed up! don't know what it does tho!!!

        } catch (Exception e){
            e.printStackTrace();
        }



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



    public void Dashboard(Scene scene){
        try {
            Button Dashboardprob=(Button)scene.lookup("#Dashboard");

            Dashboardprob.setOnAction(event -> {

                FXMLLoader Loader = new FXMLLoader(getClass().getResource("../view/fxml/Dashboard.fxml"));
                Parent root = null;
                try {
                    root =  Loader.load();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }

                Scene sc2 = new Scene(root, 849, 494);
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
                view.intervention(sc2);


            });

        } catch (Exception e) {
            e.printStackTrace();
        }



    }

}
