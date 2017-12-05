package tn.medtech.sweng.gemo.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import tn.medtech.sweng.gemo.daoimpl.MedDaoImpl;
import tn.medtech.sweng.gemo.entities.Med;

import java.util.List;

public class MedController {
    public MedController(){}


    public  void delete2 (int d) {

        MedDaoImpl meddao = new MedDaoImpl();
        meddao.delete(d);
    }

    public  void update2 (int id, String name , int x) {

        MedDaoImpl meddao = new MedDaoImpl();
        Med med = new Med();

        med.setId(id);
        med.setName(name);

        meddao.update(med, x);

    }

    public  void add2 (int id, String name ) {

        MedDaoImpl medDao1 = new MedDaoImpl();
        Med med = new Med();
        med.setId(id);
        med.setName(name);
        medDao1.insert(med);

    }


    public static ObservableList fillTable2 () {


        MedDaoImpl allmeds = new MedDaoImpl();

        List<Med> meds = allmeds.selectAll();
        ObservableList<Med> oblmeds = FXCollections.observableArrayList();
        for (Med p : meds) {
            oblmeds.add(p);
        }

        return oblmeds;
    }

    public boolean checkId2 (int id) {
        MedDaoImpl dao = new MedDaoImpl();
        if (dao.checkId(id) >= 0)
            return true;
        else
            return false;
    }
}