package tn.medtech.sweng.gemo.dao;

import tn.medtech.sweng.gemo.entities.Problem;

import java.util.List;


public interface ProblemDao {


    void insert(Problem problem);
    void delete (int id);

    void update (Problem problem , int id);
}

