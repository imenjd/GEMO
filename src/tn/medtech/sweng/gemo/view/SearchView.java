package tn.medtech.sweng.gemo.view;

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
import tn.medtech.sweng.gemo.controller.SearchController;
import tn.medtech.sweng.gemo.entities.Search;



public class SearchView {


    public SearchView() {
    }

    public static void fillCombobox(Scene scene) {
        ObservableList<String> option_one = FXCollections.observableArrayList("Problème", "DCI", "Médicament", "Intervention", "Contexte", "Commentaire", "Date", "Patient", "Service");
        Button searchbtn = (Button) scene.lookup("#BtnSearch");
        ComboBox CBSearch = (ComboBox) scene.lookup("#CBSearchBy");
        ComboBox keyword = (ComboBox) scene.lookup("#keyword");
        Label warning = (Label)scene.lookup("#warning");
        TableView searchTable = (TableView) scene.lookup("#SearchResult");
        SearchController a = new SearchController();
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
        SearchController a=new SearchController();
        TableColumn<Search,String> id_visite=new TableColumn<Search,String>("Ref visite");
        id_visite.setCellValueFactory(new PropertyValueFactory<>("ref"));
        TableColumn<Search,String> id_patient=new TableColumn<Search,String>("ID patient");
        id_patient.setCellValueFactory(new PropertyValueFactory<>("idpatient"));
        TableColumn<Search,String> service=new TableColumn<Search,String>("Service");
        service.setCellValueFactory(new PropertyValueFactory<>("service"));
        TableColumn<Search,String> fn=new TableColumn<Search,String>("First Name");
        fn.setCellValueFactory(new PropertyValueFactory<>("firstname"));
        TableColumn<Search,String> ln=new TableColumn<Search,String>("Last Name");
        ln.setCellValueFactory(new PropertyValueFactory<>("lastname"));
        searchTable.getColumns().setAll(id_visite,id_patient,service,fn,ln);
        searchbtn.setOnAction(event ->{
            String first=String.valueOf(CBSearch.getValue().toString());
            String second=String.valueOf(keyword.getValue().toString());
            if (second.isEmpty()){
                warning.setText("You have to specify your search");
            }
            else{
                warning.setText("");
            }

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
    }
    public void getLoad(Scene scene){
        Button btnload=(Button)scene.lookup("#btnload");
        TextField b=(TextField)scene.lookup("#idvisite");
        Label warning =(Label)scene.lookup("#warning");


        btnload.setOnAction(event -> {
            String idtosearch=b.getText();
            if(idtosearch.isEmpty()){
                warning.setText("Specify your id");
            }
            else{
                warning.setText("");

                FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/fxml/Details.fxml"));
                Parent root1=null;
                try {
                    root1=loader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Scene sc=new Scene(root1);
                Stage stage=new Stage();
                stage.setTitle("More Details");
                stage.setScene(sc);
                stage.show();
                SearchDetailsView view=new SearchDetailsView();
                view.fillFields(sc,idtosearch);
            }

        });
    }


    public void addPatient(Scene scene){
        try {
        Button addPatientbt=(Button)scene.lookup("#addPatient");

        addPatientbt.setOnAction(event -> {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/fxml/Patients1.fxml"));
            Parent root = null;
            try {
                root =  fxmlLoader.load();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            SearchView sview = new SearchView();
            String u=sview.SessionStorage(scene);

            Scene sc2 = new Scene(root);
            Stage newstage =  (Stage)((Node) event.getSource()).getScene().getWindow();
            newstage.setScene(sc2);
            newstage.show();

            Label username =(Label)sc2.lookup("#username");
            username.setText(u);

            PatientView view = new PatientView();
            view.add(sc2);
            view.update(sc2);
            view.homebtn(sc2);
        });

        } catch (Exception e) {
        e.printStackTrace();
        }



    }


    public void addVisit(Scene scene){
        try {
            Button addVisit=(Button)scene.lookup("#addVisit");

            addVisit.setOnAction(event -> {

                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/fxml/Visite.fxml"));
                Parent root = null;
                try {
                    root =  fxmlLoader.load();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                SearchView sview = new SearchView();
                String u=sview.SessionStorage(scene);

                Scene sc2 = new Scene(root);
                Stage newstage =  (Stage)((Node) event.getSource()).getScene().getWindow();
                newstage.setScene(sc2);
                newstage.show();

                Label username =(Label)sc2.lookup("#username");
                username.setText(u);

                VisitView.add(sc2);
                VisitView.update(sc2);
                VisitView view = new VisitView();
                view.ServiceLoad(sc2);
                view.DciLoad(sc2);
                view.interload(sc2);
                view.patientload(sc2);
                view.problemload(sc2);
                view.homebtn(sc2);
            });

        } catch (Exception e) {
            e.printStackTrace();
        }



    }


    public void logout(Scene scene){
        try {
            Button logout=(Button)scene.lookup("#logout");

            logout.setOnAction(event -> {

                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/fxml/Login.fxml"));
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

        Label username =(Label)scene.lookup("#username");

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

                SearchView sview = new SearchView();
                String u=sview.SessionStorage(scene);

                Scene sc2 = new Scene(root, 849, 494);
                Stage newstage =  (Stage)((Node) event.getSource()).getScene().getWindow();
                newstage.setScene(sc2);
                newstage.show();
                Label username =(Label)sc2.lookup("#username");
                username.setText(u);

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
