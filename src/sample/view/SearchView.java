package sample.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import java.io.IOException;
import javafx.stage.Stage;
import sample.controller.ControllerDetails;
import sample.entities.Search;
import sample.controller.ControllerSearch;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import java.util.Optional;
import javafx.scene.control.MenuItem;
import javafx.event.EventHandler;
import sample.entities.User;

import javax.xml.soap.Text;

public class SearchView {
	
	
	public static void fillCombobox(Scene scene) {
		ObservableList<String> option_one = FXCollections.observableArrayList("Problème", "DCI", "Médicament", "Intervention", "Contexte", "Commentaire", "Date", "Patient", "Service");
		Button searchbtn = (Button) scene.lookup("#BtnSearch");
		ComboBox CBSearch = (ComboBox) scene.lookup("#CBSearchBy");
		ComboBox keyword = (ComboBox) scene.lookup("#keyword");
		Label warning = (Label)scene.lookup("#warning");
		TableView searchTable = (TableView) scene.lookup("#SearchResult");
		ControllerSearch a = new ControllerSearch();
		ObservableList<String> fill_problem = a.fillProblemlist();
		ObservableList<String> fill_inter = a.fillInterlit();
		ObservableList<String> fill_med = a.fillMedlist();
		
		CBSearch.setItems(option_one);
		
		CBSearch.setOnAction(event -> {
			String first = String.valueOf(CBSearch.getValue().toString());
			if(first.equals("Problème")) {
				keyword.setItems(fill_problem);
			} else if(first.equals("Médicament")) {
				keyword.setItems(fill_med);
			} else if(first.equals("Intervention")) {
				keyword.setItems(fill_inter);
			} else {
				keyword.setItems(null);
			}
			
		});
	}
	public static void filltable(Scene scene){
		Button searchbtn = (Button) scene.lookup("#BtnSearch");
		ComboBox CBSearch = (ComboBox) scene.lookup("#CBSearchBy");
		ComboBox keyword = (ComboBox) scene.lookup("#keyword");
		TableView searchTable = (TableView) scene.lookup("#SearchResult");
		Label warning = (Label) scene.lookup("#warning");
		ControllerSearch a=new ControllerSearch();
		TableColumn<Search,String> id_visite=new TableColumn<Search,String>("Num visite");
		id_visite.setCellValueFactory(new PropertyValueFactory<>("ref"));
		TableColumn<Search,String> id_patient=new TableColumn<Search,String>("Num patient");
		id_patient.setCellValueFactory(new PropertyValueFactory<>("idpatient"));
		TableColumn<Search,String> service=new TableColumn<Search,String>("Service");
		service.setCellValueFactory(new PropertyValueFactory<>("service"));
		TableColumn<Search,String> fn=new TableColumn<Search,String>("Nom");
		fn.setCellValueFactory(new PropertyValueFactory<>("lastname"));
		TableColumn<Search,String> ln=new TableColumn<Search,String>("Prenom");
		ln.setCellValueFactory(new PropertyValueFactory<>("firstname"));
		searchTable.getColumns().setAll(id_visite,id_patient,service,fn,ln);
		
		searchbtn.setOnAction(event ->{
			String first=String.valueOf(CBSearch.getValue().toString());
			String second=String.valueOf(keyword.getValue().toString());
			
			
			if(first.equals("Problème")){
				searchTable.setItems(a.SearchbProblem(second));
			}
			else if(first.equals("DCI")){
				searchTable.setItems(a.SearchByDci(second));
			}
			else if(first.equals("Médicament")){
				searchTable.setItems(a.SearchByMed(second));
			}
			else if(first.equals("Intervention")){
				searchTable.setItems(a.SearchByIntervention(second));
			}
			else if(first.equals("Contexte")){
				searchTable.setItems(a.SearchbContexte(second));
			}
			else if(first.equals("Commentaire")){
				searchTable.setItems(a.SearchByCom(second));
			}
			else if(first.equals("Date")){
				searchTable.setItems(a.SearchByDate(second));
			}
			else if(first.equals("Patient")){
				searchTable.setItems(a.SearchByPat(second));
			}
			else if(first.equals("Service")){
				searchTable.setItems(a.SearchByService(second));
			}

		});
		String reference="";
		searchTable.setRowFactory(tv -> {
			TableRow<Search> row = new TableRow<>();
			row.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() {
				@Override
				public void handle(javafx.scene.input.MouseEvent event) {
					if(event.getClickCount() == 2 && (!row.isEmpty())) {
						String rowdata = row.getItem().getRef();
						FXMLLoader Loader = new FXMLLoader(getClass().getResource("../view/fxml/MoreDetails.fxml"));
						Parent root1 = null;
						Search a=new Search();
						a.setRef(rowdata);
						try {
							root1 = Loader.load();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						//PatientView pview = new PatientView();
						//String u=pview.SessionStorage(scene);
						
						
						Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
						stage.setTitle("Home Page");
						Scene sc2 = new Scene(root1);
						SearchDetailsView f=new SearchDetailsView();
						//VisitController f=new VisitController();
						//int val2=f.SearchLastID();
						stage.setScene(sc2);
						stage.show();
						//VisitView b = new VisitView();
						f.fillFields(sc2,rowdata);
						
					}
					
				}
			});
			return row;
			
		});
		
		
	}
	
	
	public void addVisit(Scene scene){
		
		
				Button visit=(Button)scene.lookup("#addVisit");
				
				visit.setOnAction(event -> {
					FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/fxml/visitepre.fxml"));
					Parent root = null;
					try {
						root =  fxmlLoader.load();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					
					Scene sc2 = new Scene(root);
					Stage newstage =  (Stage)((Node) event.getSource()).getScene().getWindow();
					newstage.setScene(sc2);
					newstage.show();
					PreVisiteVIew a=new PreVisiteVIew();
					a.choose(sc2);
					
				});
					
				}
				
	
	
	public void logout(Scene scene){
		try {
			Button logout=(Button)scene.lookup("#LogOut");
			
			logout.setOnAction(event -> {
				
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/fxml/SignIn.fxml"));
				Parent root = null;
				try {
					root =  fxmlLoader.load();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				Scene sc2 = new Scene(root);
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
	public String SessionStorage(Scene scene){
		
		TextField username =(TextField) scene.lookup("#txtUserName");
		
		String u= username.getText();
		
		
		return  u;
	}
	
	public void Dashboard(Scene scene){
		try {
			Button Dashboard=(Button)scene.lookup("#Dashboard");
			
			Dashboard.setOnAction(event -> {
				
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/fxml/Dashboard.fxml"));
				Parent root = null;
				try {
					root =  fxmlLoader.load();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				//SearchView a=new SearchView();
				//String u=a.SessionStorage(scene);
				
				SearchView sview=new SearchView();
				String u=sview.SessionStorage(scene);
				
				Scene sc2 = new Scene(root, 849, 494);
				Stage newstage =  (Stage)((Node) event.getSource()).getScene().getWindow();
				newstage.setScene(sc2);
				newstage.show();
				TextField username =(TextField) scene.lookup("#txtUserName");
				username.setText(u);
				HomeView view = new HomeView();
				view.dci(sc2);
				view.med(sc2);
				view.problem(sc2);
				view.service(sc2);
				view.userpending(sc2);
				view.user(sc2);
				view.Home(sc2);
				view.intervention(sc2);
				view.patient(sc2);
				
			});
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	}
	
		
			
			
			
	
		
		
		
	
