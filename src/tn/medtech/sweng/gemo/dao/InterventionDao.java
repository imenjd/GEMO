package tn.medtech.sweng.gemo.dao;



import tn.medtech.sweng.gemo.entities.Intervention;

import java.util.List;


public interface InterventionDao {


    void insert(Intervention intervention);
    void delete (int id);

    void update (Intervention intervention , int id);
}
