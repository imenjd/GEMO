package sample.view;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import sample.controller.UserController;
import sample.controller.SignUpController;
import java.io.*;

public class SignUpView {
	public SignUpView() {
	}
	
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
		CheckBox cc = (CheckBox)scene1.lookup("#check");
		
		try {
			btnS.setOnAction(actionEvent -> {
				String l = lastName.getText();
				String f = firstName.getText();
				String u = userName.getText();
				String p2 = pass2.getText();
				String em = email.getText();
				String o = occupation.getText();
				String p = password.getText();
				boolean c=cc.isSelected();
				
				
				if (l.isEmpty() || f.isEmpty() || u.isEmpty() || em.isEmpty() || o.isEmpty() || p.isEmpty()) {
					lbl.setText("You can not leave an empty field.");
				} else if (!SignUpController.doesPasswordMatch(p, p2)) {
					lbl.setText("Passwords do not match!");
				}   else if( !(SignUpController.checkUsername(u))){
					
					lbl.setText("Choose a different UserName, it alreasy exists!!");
				}
				
				else {
					System.out.println(c);
					SignUpController ctrler = new SignUpController();
					ctrler.add(f, l, u, p, p2, em, o, c);
					lbl.setText("Successfully registered! wait for approval.");
				}
				
			});
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void toLogin(Scene scene) {
		try {
			Button BtnToLogin = (Button) scene.lookup("#ToLogin");
			
			BtnToLogin.setOnAction(event -> {
				
				
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/fxml/SignIn.fxml"));
				Parent root1 = null;
				try {
					root1 =  fxmlLoader.load();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				Scene sc2 = new Scene(root1);
				Stage newstage =  (Stage)((Node) event.getSource()).getScene().getWindow();
				newstage.setScene(sc2);
				newstage.show();
				UserView view = new UserView();
				view.BtnLogin(sc2);
				view.ToSignUp(sc2);
				
				
				
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
