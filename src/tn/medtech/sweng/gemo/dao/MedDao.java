package tn.medtech.sweng.gemo.dao;



import tn.medtech.sweng.gemo.entities.Med;

import java.util.List;

public interface MedDao {


    void insert(Med med);
    void update(Med med , int id);
    void delete(int id);
    Med selectByName(String name);
    Med selectById ( int id);

    List<Med> selectAll();
    int  checkId(int id);
}
