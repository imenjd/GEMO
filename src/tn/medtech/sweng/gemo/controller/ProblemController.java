package tn.medtech.sweng.gemo.controller;
import tn.medtech.sweng.gemo.daoimpl.ProblemDaoImpl;
import tn.medtech.sweng.gemo.entities.Problem;

public class ProblemController {
    public ProblemController() {
    }
    public static void insert(String name){
        Problem problem=new Problem();
        problem.setName(name);
        ProblemDaoImpl dao=new ProblemDaoImpl();
        dao.insert(problem);
    }
    public static void update(String name,int id){
        ProblemDaoImpl dao=new ProblemDaoImpl();
        Problem problem=new Problem(id,name);
        dao.update(problem,id);
    }
    public static void delete(int id){
        ProblemDaoImpl dao=new ProblemDaoImpl();
        dao.delete(id);
    }
}

