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
import java.net.URL;
import java.util.Optional;

import javafx.stage.Stage;


import sample.entities.Search;
import sample.controller.ControllerSearch;

import javafx.event.EventHandler;


public class SearchView {
	Parent Root;
	URL url;
	
	
	public static void fillCombobox(Scene scene) {
		ObservableList<String> option_one = FXCollections.observableArrayList("Problème", "DCI", "Médicament", "Intervention", "Contexte", "Commentaire", "Date", "Patient", "Service");
		
		ComboBox CBSearch = (ComboBox) scene.lookup("#CBSearchBy");
		ComboBox keyword = (ComboBox) scene.lookup("#keyword");
		
		
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
	public  void filltable(Scene scene){
		Button searchbtn = (Button) scene.lookup("#BtnSearch");
		ComboBox CBSearch = (ComboBox) scene.lookup("#CBSearchBy");
		ComboBox keyword = (ComboBox) scene.lookup("#keyword");
		TableView searchTable = (TableView) scene.lookup("#SearchResult");
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
		
		
		searchbtn.setOnAction(event ->{
			String first=String.valueOf(CBSearch.getValue().toString());
			String second=String.valueOf(keyword.getValue().toString());
			
			
			if(first.equals("Problème")){
				searchTable.setItems(a.SearchbProblem(second));
				searchTable.getColumns().setAll(id_visite,id_patient,service,fn,ln);
			}
			else if(first.equals("DCI")){
				searchTable.setItems(a.SearchByDci(second));
				searchTable.getColumns().setAll(id_visite,id_patient,service,fn,ln);
			}
			else if(first.equals("Médicament")){
				searchTable.setItems(a.SearchByMed(second));
				searchTable.getColumns().setAll(id_visite,id_patient,service,fn,ln);
			}
			else if(first.equals("Intervention")){
				searchTable.setItems(a.SearchByIntervention(second));
				searchTable.getColumns().setAll(id_visite,id_patient,service,fn,ln);
			}
			else if(first.equals("Contexte")){
				searchTable.setItems(a.SearchbContexte(second));
				searchTable.getColumns().setAll(id_visite,id_patient,service,fn,ln);
			}
			else if(first.equals("Commentaire")){
				searchTable.setItems(a.SearchByCom(second));
				searchTable.getColumns().setAll(id_visite,id_patient,service,fn,ln);
			}
			else if(first.equals("Date")){
				searchTable.setItems(a.SearchByDate(second));
				searchTable.getColumns().setAll(id_visite,id_patient,service,fn,ln);
			}
			else if(first.equals("Patient")){
				searchTable.setItems(a.SearchByPat(second));
				searchTable.getColumns().setAll(id_visite,id_patient,service,fn,ln);
			}
			else if(first.equals("Service")){
				searchTable.setItems(a.SearchByService(second));
				searchTable.getColumns().setAll(id_visite,id_patient,service,fn,ln);
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
						url = getClass().getClassLoader().getResource("sample/view/fxml/MoreDetails.fxml");
						try {
							Root = FXMLLoader.load(url);
						} catch (IOException e) {
							e.printStackTrace();
						}
						
					
						
						
						Stage stage = new Stage();
						stage.setTitle("Plus de détails");
						
						Scene sc2 = new Scene(Root);
						stage.setScene(sc2);
						SearchDetailsView f=new SearchDetailsView();
						
						stage.setScene(sc2);
						stage.show();
						f.fillFields(sc2,rowdata);
						
					}
					
				}
			});
			return row;
			
		});
		
		
	}
	
	
	public void addVisit(Scene scene, String b){
		
		
				Button visit=(Button)scene.lookup("#addVisit");
				
				visit.setOnAction(event -> {
					Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
					alert.setTitle("Nouveau/Ancien Patient");
					alert.setHeaderText("Veuillez-sélectionner une option :");
					
					ButtonType newp = new ButtonType("Nouveau Patient ?");
					ButtonType oldp = new ButtonType("Ancien Patient ?");
					
					
					
					alert.getButtonTypes().clear();
					
					alert.getButtonTypes().addAll(newp,oldp);
					
					// option != null.
					Optional<ButtonType> option = alert.showAndWait();
					
					if (option.get() == newp) {
						url  = getClass().getClassLoader().getResource("sample/view/fxml/Patient.fxml");
						try {
							Root = FXMLLoader.load(url);
						} catch (IOException e) {
							e.printStackTrace();
						}
						
						
						
						Scene sc2 = new Scene(Root);
						TextField username =(TextField)sc2.lookup("#username");
						username.setText(b);
						Stage newstage =  (Stage)((Node) event.getSource()).getScene().getWindow();
						newstage.setScene(sc2);
						newstage.setTitle("Nouveau Patient");
						newstage.show();
						PatientView a=new PatientView();
						a.add(sc2,b);
						a.homebtn(sc2,b);
						
						
					}
					 else  {
						url  = getClass().getClassLoader().getResource("sample/view/fxml/Ancien.fxml");
						try {
							Root = FXMLLoader.load(url);
						} catch (IOException e) {
							e.printStackTrace();
						}
						
			
			
					Scene sc3 = new Scene(Root);
					TextField username =(TextField)sc3.lookup("#username");
					username.setText(b);
					Stage newstage =  (Stage)((Node) event.getSource()).getScene().getWindow();
						newstage.setTitle("Ancien Patient");
					newstage.setScene(sc3);
					newstage.show();
					PatientView c=new PatientView();
					c.SearchPatient(sc3,b);
					c.homebtn(sc3,b);
			
		}
		
	});
				
				
				
				
				
					
				}
	
				
	
	
	public void logout(Scene scene){
		
		Button logout=(Button)scene.lookup("#LogOut");
		try {
			
			
			logout.setOnAction(event -> {
				url  = getClass().getClassLoader().getResource("sample/view/fxml/SignIn.fxml");
				try {
					Root = FXMLLoader.load(url);
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				
				
				Scene sc2 = new Scene(Root);
				Stage newstage =  (Stage)((Node) event.getSource()).getScene().getWindow();
				newstage.setScene(sc2);
				newstage.setTitle("Connexion");
				newstage.show();
				UserView view = new UserView();
				view.BtnLogin(sc2);
				view.ToSignUp(sc2);
				
			});
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	
	public void Dashboard(Scene scene, String b){
		Button Dashboard=(Button)scene.lookup("#Dashboard");
		
			
			Dashboard.setOnAction(event -> {
				url  = getClass().getClassLoader().getResource("sample/view/fxml/Dashboard.fxml");
				try {
					Root = FXMLLoader.load(url);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				
				Scene sc2 = new Scene(Root, 720, 540);
				Stage newstage =  (Stage)((Node) event.getSource()).getScene().getWindow();
				newstage.setScene(sc2);
				newstage.show();
				TextField username =(TextField) sc2.lookup("#txtUserName");
					newstage.setTitle("Menu");
				username.setText(b);
				HomeView view = new HomeView();
				
				view.dci(sc2,b);
				view.med(sc2,b);
				view.problem(sc2,b);
				view.service(sc2,b);
				view.userpending(sc2,b);
				view.user(sc2,b);
				view.Home(sc2,b);
				view.intervention(sc2,b);
				view.patient(sc2,b);
				
				
				
				
			});
			
		
		
	}
	
	}
