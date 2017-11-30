package tn.medtech.sweng.gemo.controller;

public class VisitController {
    public VisitController() {
    }

    public static void add(int idp,String date, String comment, int ids ){
        Visit visit =new Visit();
        visit.setIdp(idp);
        visit.setDate(date);
        visit.setComment(comment);
        visit.setIds(ids);

        VisiteDaoImp dao=new VisiteDaoImp();
        dao.insert(visit);
    }
    public static void update(int idp,String date, String comment,int ids,int id){
        Visit visit =new Visit();
        visit.setIdp(idp);
        visit.setDate(date);
        visit.setComment(comment);
        visit.setIds(ids);

        VisiteDaoImp dao=new VisiteDaoImp();
        dao.update(visit,id);
    }
    public static boolean exist(int id){
        VisiteDaoImp dao=new VisiteDaoImp();

        return dao.exist(id);
    }
}
