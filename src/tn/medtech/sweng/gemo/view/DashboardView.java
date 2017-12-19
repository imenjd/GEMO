package tn.medtech.sweng.gemo.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class DashboardView {


    public void Home (Scene scene) {

        try {
            Button Home;
            Home = (Button)scene.lookup("#Home");

            Home.setOnAction(event -> {

                FXMLLoader Loader = new FXMLLoader(getClass().getResource("../view/fxml/Home.fxml"));
                Parent root = null;
                try {
                    root =  Loader.load();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }

                Scene sc2 = new Scene(root,1000,550);
                Stage newstage =  (Stage)((Node) event.getSource()).getScene().getWindow();
                newstage.setScene(sc2);
                newstage.show();
                SearchView searchView=new SearchView();
                searchView.fillCombobox(sc2);
                searchView.filltable(sc2);
                searchView.getLoad(sc2);
                searchView.addPatient(sc2);
                searchView.addVisit(sc2);
                searchView.logout(sc2);
                searchView.Dashboard(sc2);


            });

        } catch (Exception e) {
            e.printStackTrace();
        }



    }

    public void dci (Scene scene) {

        try {
            Button dci=(Button)scene.lookup("#dci");

            dci.setOnAction(event -> {

                FXMLLoader Loader = new FXMLLoader(getClass().getResource("../view/fxml/Dci.fxml"));
                Parent root = null;
                try {
                    root =  Loader.load();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }

                Scene sc2 = new Scene(root, 596, 638);
                Stage newstage =  (Stage)((Node) event.getSource()).getScene().getWindow();
                newstage.setScene(sc2);
                newstage.show();
                DciView view3 = new DciView();
                view3.winInfo(sc2);
                view3.fillTable(sc2);
                view3.add(sc2);
                view3.delete(sc2);
                view3.update(sc2);
                view3.Dashboard(sc2);



            });

        } catch (Exception e) {
            e.printStackTrace();
        }



    }

    public void med (Scene scene) {

        try {
            Button med=(Button)scene.lookup("#med");

            med.setOnAction(event -> {

                FXMLLoader Loader = new FXMLLoader(getClass().getResource("../view/fxml/Med.fxml"));
                Parent root = null;
                try {
                    root =  Loader.load();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }

                Scene sc2 = new Scene(root, 596, 638);
                Stage newstage =  (Stage)((Node) event.getSource()).getScene().getWindow();
                newstage.setScene(sc2);
                newstage.show();
                MedView view1 = new MedView();
                view1.fillTable2(sc2);
                view1.add2(sc2);
                view1.delete2(sc2);
                view1.update2(sc2);

                view1.winInfo(sc2);
                view1.Dashboard(sc2);


            });

        } catch (Exception e) {
            e.printStackTrace();
        }



    }
    public void problem (Scene scene) {

        try {
            Button problem=(Button)scene.lookup("#problem");

            problem.setOnAction(event -> {

                FXMLLoader Loader = new FXMLLoader(getClass().getResource("../view/fxml/Problem.fxml"));
                Parent root = null;
                try {
                    root =  Loader.load();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }

                Scene sc2 = new Scene(root, 596, 638);
                Stage newstage =  (Stage)((Node) event.getSource()).getScene().getWindow();
                newstage.setScene(sc2);
                newstage.show();
                ProblemView view = new ProblemView();
                view.insert(sc2);
                view.update(sc2);
                view.delete(sc2);
                view.fillTable(sc2);
                view.winInfo(sc2);
                view.Dashboard(sc2);


            });

        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    public void intervention (Scene scene) {

        try {
            Button problem=(Button)scene.lookup("#interventions");

            problem.setOnAction(event -> {

                FXMLLoader Loader = new FXMLLoader(getClass().getResource("../view/fxml/Intervention.fxml"));
                Parent root = null;
                try {
                    root =  Loader.load();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }

                Scene sc2 = new Scene(root, 596, 638);
                Stage newstage =  (Stage)((Node) event.getSource()).getScene().getWindow();
                newstage.setScene(sc2);
                newstage.show();
                InterventionView view = new InterventionView();
               view.Dashboard(sc2);
               view.insert(sc2);
               view.delete(sc2);
               view.update(sc2);
               view.winInfo(sc2);
               view.fillTable(sc2);






            });

        } catch (Exception e) {
            e.printStackTrace();
        }


    }



    public void service (Scene scene) {

        try {
            Button service=(Button)scene.lookup("#service");

            service.setOnAction(event -> {

                FXMLLoader Loader = new FXMLLoader(getClass().getResource("../view/fxml/services.fxml"));
                Parent root = null;
                try {
                    root =  Loader.load();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }

                Scene sc2 = new Scene(root, 596, 638);
                Stage newstage =  (Stage)((Node) event.getSource()).getScene().getWindow();
                newstage.setScene(sc2);
                newstage.show();
                ServiceView view = new ServiceView();
                view.fillTable(sc2);
                view.add(sc2);
                view.delete(sc2);
                view.update(sc2);
                view.winInfo(sc2);
                view.Dashboard(sc2);



            });

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void userpending (Scene scene) {

        try {
            Button userpending=(Button)scene.lookup("#userpending");

            userpending.setOnAction(event -> {

                FXMLLoader Loader = new FXMLLoader(getClass().getResource("../view/fxml/UserPending.fxml"));
                Parent root = null;
                try {
                    root =  Loader.load();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }

                Scene sc2 = new Scene(root);
                Stage newstage =  (Stage)((Node) event.getSource()).getScene().getWindow();
                newstage.setScene(sc2);
                newstage.show();
                UserPendingView view = new UserPendingView();
                view.fillTable(sc2);
                view.reject(sc2);
                view.accept(sc2);

                view.winInfo(sc2);
                view.UserInfo(sc2);
                view.Dashboard(sc2);


            });

        } catch (Exception e) {
            e.printStackTrace();
        }



    }

    public void user (Scene scene) {


            try {
                Button user=(Button)scene.lookup("#user");

                user.setOnAction(event -> {

                    FXMLLoader Loader = new FXMLLoader(getClass().getResource("../view/fxml/Users.fxml"));
                    Parent root = null;
                    try {
                        root =  Loader.load();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }

                    Scene sc2 = new Scene(root);
                    Stage newstage =  (Stage)((Node) event.getSource()).getScene().getWindow();
                    newstage.setScene(sc2);
                    newstage.show();
                    UserView uview = new UserView();
                    uview.fillTable(sc2);

                    UserDashboardView view = new UserDashboardView();
                    view.Dashboard(sc2);
                    view.delete(sc2);
                    uview.fillTable(sc2);



                });

            } catch (Exception e) {
                e.printStackTrace();
            }



    }


}


