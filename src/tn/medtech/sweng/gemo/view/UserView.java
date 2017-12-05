package tn.medtech.sweng.gemo.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import tn.medtech.sweng.gemo.controller.SignUpController;
import tn.medtech.sweng.gemo.controller.UserController;
import tn.medtech.sweng.gemo.entities.User;
import tn.medtech.sweng.gemo.view.SignUpView;

import java.io.IOException;

public class UserView {

    public UserView() {
    }

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



    public static void fillTable (Scene scene) {

        try{
            TableView TableUser  = (TableView) scene.lookup("#TableUser");

            //view
            UserController controller =new UserController();

            TableUser.setItems(controller.fillTable());


            TableColumn<User,Integer> columnid = new TableColumn<User,Integer>("Id");
            columnid.setCellValueFactory(new PropertyValueFactory("id"));
            TableColumn<User,String> columnfirstname = new TableColumn<User,String>("FirstName");
            columnfirstname.setCellValueFactory(new PropertyValueFactory("firstName"));
            TableColumn<User,String> columnlastname = new TableColumn<User,String>("LastName");
            columnlastname.setCellValueFactory(new PropertyValueFactory("lastName"));
            TableColumn<User,String> columnusername = new TableColumn<User,String>("UserName");
            columnusername.setCellValueFactory(new PropertyValueFactory("userName"));
            TableColumn<User,String> columnstatus = new TableColumn<User,String>("Status");
            columnstatus.setCellValueFactory(new PropertyValueFactory("status"));
            TableColumn<User,String> columnemail = new TableColumn<User,String>("email");
            columnemail.setCellValueFactory(new PropertyValueFactory("email"));
            TableColumn<User,String> columnpassword = new TableColumn<User,String>("password");
            columnpassword.setCellValueFactory(new PropertyValueFactory("password"));
            TableColumn<User,Boolean> columnadmin = new TableColumn<User,Boolean>("Admin");
            columnadmin.setCellValueFactory(new PropertyValueFactory("admin"));

            TableUser.getColumns().setAll(columnid, columnfirstname,columnlastname,columnusername,columnemail,columnpassword,columnadmin);
            TableUser.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        } catch (Exception e){
            e.printStackTrace();
        }

    }

}

