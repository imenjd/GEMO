package tn.medtech.sweng.gemo.view;

import java.lang.Exception;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.*;

public class ViewView {
    Scene scene;


    public static void add(Scene scene){
        Button add= (Button) scene.lookup("#add");
        final TextField idp=  (TextField) scene.lookup("#idp");
        final TextField ids=  (TextField) scene.lookup("#ids");
        final TextField comment= (TextField) scene.lookup("#comment");
        final DatePicker date= (DatePicker) scene.lookup("#date");
        Label label=(Label) scene.lookup("#label") ;

try {


    add.setOnAction(event -> {

        int ids1 = Integer.parseInt(ids.getText());
        int idp1 = Integer.parseInt(idp.getText());
        String date1 = date.getValue().toString();
        String comment1 = comment.getText();

        Controller.add(idp1, date1, comment1, ids1);
        label.setText("Added successfully !!");


    });
}catch (Exception e){
    e.printStackTrace();
}
    }
    public static void update(Scene scene){

        Button update=(Button) scene.lookup("#update");
        final TextField idp=  (TextField) scene.lookup("#idp");
        final TextField ids=  (TextField) scene.lookup("#ids");
        final TextField comment= (TextField) scene.lookup("#comment");
        final DatePicker date= (DatePicker) scene.lookup("#date");
        Label label=(Label) scene.lookup("#label") ;
        final TextField id=(TextField) scene.lookup("#id");

        update.setOnAction(event -> {

            try {

                int ids1 =Integer.parseInt(ids.getText());
                int idp1 = Integer.parseInt(idp.getText());
                String date1=date.getValue().toString();
                String comment1=comment.getText();
                int idd;
                idd = Integer.valueOf(id.getText());
                if (Controller.exist(idd)) {
                    Controller.update(idp1,date1,comment1, ids1, idd);
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

