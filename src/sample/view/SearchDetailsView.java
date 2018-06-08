package sample.view;

import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import sample.controller.ControllerDetails;

import java.util.List;

public class SearchDetailsView {
	public  void fillFields(Scene scene,String val) {
		
		try {
			TextField idpatient=(TextField) scene.lookup("#id_patient");
			TextField patientfn=(TextField) scene.lookup("#fn_patient");
			TextField patientln=(TextField) scene.lookup("#ln_patient");
			TextField dbpatient=(TextField) scene.lookup("#db_patient");
			
			TextField idvisite=(TextField) scene.lookup("#id_visit");
			TextField datevisite=(TextField) scene.lookup("#date_visit");
			TextField service=(TextField) scene.lookup("#service");
			TextField prob=(TextField) scene.lookup("#probleme");
			TextField inter=(TextField) scene.lookup("#interv");
			TextField med=(TextField) scene.lookup("#med");
			TextField dci=(TextField) scene.lookup("#dci");
			
			TextArea comm=(TextArea) scene.lookup("#comm");
			TextArea contexte=(TextArea) scene.lookup("#cxte");
			
			
			TextField userfn=(TextField) scene.lookup("#fn_user");
			TextField userln=(TextField) scene.lookup("#ln_user");
			TextField status=(TextField) scene.lookup("#status");
			ControllerDetails a=new ControllerDetails();
			List<String> b;
			b=a.fillFields(val);
		
			
			
			
			med.setText(b.get(0));
			dci.setText(b.get(1));
			idvisite.setText(b.get(2));
			idpatient.setText(b.get(3));
			datevisite.setText(b.get(4));
			comm.setText(b.get(5));
			prob.setText(b.get(6));
			patientfn.setText(b.get(7));
			patientln.setText(b.get(8));
			dbpatient.setText(b.get(9));
			userfn.setText(b.get(10));
			userln.setText(b.get(11));
			status.setText(b.get(12));
			service.setText(b.get(13));
			contexte.setText(b.get(14));
			inter.setText(b.get(15));
		}catch (Exception e){
			e.printStackTrace();
			
		}
		
		
		
		
		
		
		
	}
	
}
