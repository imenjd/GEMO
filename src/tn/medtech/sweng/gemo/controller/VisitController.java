package tn.medtech.sweng.gemo.controller;

import tn.medtech.sweng.gemo.daoimpl.VisitDaoImpl;
import tn.medtech.sweng.gemo.entities.Visit;


public class VisitController {
    public VisitController() {
    }

    public  void add(int idp, String date, String comment, int ids, int idint, String context, int iddci, int idprob, String u) {
        Visit visit = new Visit();
        visit.setIdp(idp);
        visit.setDate(date);
        visit.setComment(comment);
        visit.setIds(ids);
        visit.setIdi(idint);
        visit.setIdd(iddci);
        visit.setIdpb(idprob);
        visit.setContext(context);
        VisitDaoImpl dao = new VisitDaoImpl();
        int id= dao.findId();
        visit.setId(id);
        UserController userC = new UserController();
        int Userid= userC.sessionStorage(u);
        visit.setUserid(Userid);
        dao.insert(visit);
        dao.insert2(visit);
        dao.insert3(visit);
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
