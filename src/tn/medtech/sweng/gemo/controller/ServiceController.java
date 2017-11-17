package tn.medtech.sweng.gemo.controller;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import tn.medtech.sweng.gemo.daoimpl.ServiceDaoImpl;
import tn.medtech.sweng.gemo.entities.Service;

import java.util.List;

public class ServiceController {

    public ServiceController(){}



    public  void delete (int d) {

        ServiceDaoImpl dao = new ServiceDaoImpl();
        dao.delete(d);
    }

    public  void update (int id, String name , int x) {

        ServiceDaoImpl dao = new ServiceDaoImpl();
        Service service = new Service();

        service.setId(id);//controller
        service.setName(name);//controller

        dao.update(service, x);//controller

    }

    public  void add (int id, String name ) {

        ServiceDaoImpl hedi = new ServiceDaoImpl();
        Service service = new Service();
        service.setId(id);
        service.setName(name);

        hedi.insert(service);

    }


    public static ObservableList fillTable () {


        ServiceDaoImpl allservices = new ServiceDaoImpl();

        List<Service> services = allservices.selectAll();
        ObservableList<Service> oblservices = FXCollections.observableArrayList();
        for (Service p : services) {
            oblservices.add(p);
        }

        return oblservices;
    }

}

