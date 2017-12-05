package tn.medtech.sweng.gemo.dao;

import tn.medtech.sweng.gemo.entities.Dci;

import java.util.List;

public interface DciDao {

    void insert(Dci dci);
    void update(Dci dci , int id);
    void delete(int id);
    Dci selectByName(String name);
    Dci selectById ( int id);

    List<Dci> selectAll();
    int  checkId(int id);
}
