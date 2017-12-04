package tn.medtech.sweng.gemo.view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import tn.medtech.sweng.gemo.controller.SignUpController;
import tn.medtech.sweng.gemo.controller.UserController;

public class SignUpView {

    public static void BtnSignUp(Scene scene1) {

            UserController ctrl = new UserController();
            Button btnS = (Button) scene1.lookup("#btnSignUp");

            TextField lastName = (TextField) scene1.lookup("#txtLastName");
            TextField firstName = (TextField) scene1.lookup("#txtFirstName");
            TextField email = (TextField) scene1.lookup("#txtEmail");
            PasswordField pass2 = (PasswordField) scene1.lookup("#txtConfPass");
            TextField userName = (TextField) scene1.lookup("#txtUserName1");
            TextField occupation = (TextField) scene1.lookup("#txtOccupation");
            PasswordField password = (PasswordField) scene1.lookup("#txtPassword1");
            Label lbl = (Label) scene1.lookup("#lblSign") ;

        try {
             btnS.setOnAction(actionEvent -> {
                 String l = lastName.getText();
                 String f = firstName.getText();
                 String u = userName.getText();
                 String p2 = pass2.getText();
                 String em = email.getText();
                 String o = occupation.getText();
                 String p = password.getText();


                 if (l.isEmpty() || f.isEmpty() || u.isEmpty() || em.isEmpty() || o.isEmpty() || p.isEmpty()) {
                     lbl.setText("You can not leave an empty field.");
                 } else if (!SignUpController.doesPasswordMatch(p, p2)) {
                     lbl.setText("Passwords do not match!");
                 } else {
                     boolean a = false;
                     SignUpController ctrler = new SignUpController();
                     ctrler.add(f, l, u, p, p2, em, o, a);
                 }

             });


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
