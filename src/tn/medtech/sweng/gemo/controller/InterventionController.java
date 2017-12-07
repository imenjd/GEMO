package tn.medtech.sweng.gemo.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import tn.medtech.sweng.gemo.daoimpl.InterventionDaoImpl;
import tn.medtech.sweng.gemo.entities.Intervention;

import java.util.List;

public class InterventionController {
    public InterventionController() {
    }
    public static void insert(String name){
        Intervention intervention=new Intervention();
        intervention.setName(name);
        InterventionDaoImpl dao=new InterventionDaoImpl();
        dao.insert(intervention);
    }
    public static void update(String name,int id){
        InterventionDaoImpl dao=new InterventionDaoImpl();
        Intervention intervention=new Intervention(id,name);
        dao.update(intervention,id);
    }
    public static void delete(int id){
        InterventionDaoImpl dao=new InterventionDaoImpl();

        dao.delete(id);
    }

    public static ObservableList fillTable() {


        InterventionDaoImpl allservices = new InterventionDaoImpl();

        List<Intervention> services = allservices.selectAll();
        ObservableList<Intervention> oblservices = FXCollections.observableArrayList();
        for (Intervention p : services) {
            oblservices.add(p);
        }

        return oblservices;
    }


}