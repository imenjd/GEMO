package tn.medtech.sweng.gemo.dao;

import tn.medtech.sweng.gemo.entities.Service;

import java.util.List;

public interface ServiceDao {
    void insert(Service service);
    void update(Service service , int id);
    void delete(int id);
    Service selectByName(String name);
    Service selectById ( int id);

    List<Service> selectAll();


}
