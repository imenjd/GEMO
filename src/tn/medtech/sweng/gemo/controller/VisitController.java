package tn.medtech.sweng.gemo.controller;

import tn.medtech.sweng.gemo.daoimpl.VisitDaoImpl;
import tn.medtech.sweng.gemo.entities.Visit;


public class VisitController {
    public VisitController() {
    }

    public static void add(int idp, String date, String comment, int ids) {
        Visit visit = new Visit();
        visit.setIdp(idp);
        visit.setDate(date);
        visit.setComment(comment);
        visit.setIds(ids);

        VisitDaoImpl dao = new VisitDaoImpl();
        dao.insert(visit);
    }

    public static void update(int idp, String date, String comment, int ids, int id) {
        Visit visit = new Visit();
        visit.setIdp(idp);
        visit.setDate(date);
        visit.setComment(comment);
        visit.setIds(ids);

        VisitDaoImpl dao = new VisitDaoImpl();
        dao.update(visit, id);
    }

    public static boolean exist(int id) {
        VisitDaoImpl dao = new VisitDaoImpl();

        return dao.exist(id);
    }
}
