package tn.medtech.sweng.gemo.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import tn.medtech.sweng.gemo.controller.SignUpController;
import tn.medtech.sweng.gemo.controller.UserController;
import tn.medtech.sweng.gemo.entities.User;
import tn.medtech.sweng.gemo.view.SignUpView;

import java.io.IOException;

public class UserView {
    public static void BtnLogin(Scene scene) {
        Button btn;
        TextField userName;
        PasswordField password;
        Label lblStatus;
        try {
            UserController ctrl = new UserController();
            User user = new User();
            btn = (Button) scene.lookup("#btn");
            userName = (TextField) scene.lookup("#txtUserName");
            password = (PasswordField) scene.lookup("#txtPassword");
            lblStatus = (Label) scene.lookup("#lblStatus");
            btn.setOnAction(event -> {
                String u = userName.getText().toLowerCase();
                String p = password.getText();

                if (ctrl.sample(u, p)) {

                    lblStatus.setText("Login Success");
                    Stage stage = new Stage();
                    stage.show();
                    //user.setToken();
                    //System.out.println(user.getToken());

                } else if (u.isEmpty() || p.isEmpty()) {
                    lblStatus.setText("Cannot leave username or password blank");
                    new Alert(Alert.AlertType.ERROR, "Cannot leave username or password blank.").showAndWait();

                } else {
                    lblStatus.setText("Login Failed, try again");
                    new Alert(Alert.AlertType.ERROR, "Login Failed, try again.").showAndWait();
                }

            });

        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }


    public void ToSignUp(Scene scene) {


        try {
            Button ToSignUp = (Button) scene.lookup("#ToSignUp");
            ToSignUp.setOnAction(e -> {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/SignUp.fxml"));
                Parent root1 = null;
                try {
                    root1 = (Parent) fxmlLoader.load();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                Stage stage = new Stage();
                Scene sc2 = new Scene(root1);
                stage.setScene(sc2);
                stage.show();
                SignUpView.BtnSignUp(sc2);

            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

