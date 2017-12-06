package tn.medtech.sweng.gemo.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import tn.medtech.sweng.gemo.daoimpl.SearchDetailsDaoImpl;

import java.util.List;

public class SearchDetailsController {
    public List<String> fillFields(String val){
        SearchDetailsDaoImpl dao=new SearchDetailsDaoImpl();
        List<String> s=dao.SearchById(val);

        return s;
    }
}
