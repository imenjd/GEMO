package sample.controller;
import sample.dao.DciDao;
import sample.dao.VisitDao;
import sample.entities.Visit;
import sample.daoimpl.VisitDaoImpl;
import sample.entities.*;
import sample.daoimpl.*;

import java.sql.SQLException;

public class VisitController {
	public VisitController() {
	}
	public int SearchLastID(){
		VisitDaoImpl c=new VisitDaoImpl();
		return c.searchLast();
	}
	
	
	public  void add(String user,String idp, String date, String service, String dci, String interv, String prob, String med, String contexte, String commentaire) {
		Visit visit = new Visit();
		
		DciDaoImpl dcivalue=new DciDaoImpl();
		Dci d=new Dci();
		d.setName(dci);
		dcivalue.insert(d);
		int iddci=dcivalue.selectByName(dci);
		
		
		MedDaoImpl meddao=new MedDaoImpl();
		Med m=new Med();
		m.setName(med);
		int idmed=meddao.selectByName(med);
		
		
		
		InterventionDaoImpl interdao=new InterventionDaoImpl();
		
		int idinter=interdao.selectByName(interv);
		
		
		
		ServiceDaoImpl serviceval=new ServiceDaoImpl();
		Service s=new Service();
	
		s.setName(service);
		serviceval.insert(s);
		int idservice=serviceval.selectByName(service);
		
		
		ProblemDaoImpl problemval=new ProblemDaoImpl();
		int idprob=problemval.selectByName(prob);
		
		
		
		
		
		UserDaoImpl u=new UserDaoImpl();
		User b=new User();
		b.setUserName(user);
		int idUser=u.selectByName(user);
		
		
		visit.setIdp(Integer.parseInt(idp));
		visit.setDate(date);
		visit.setCommentaire(commentaire);
	
		
		visit.setService(idservice);
		visit.setContexte(contexte);
		visit.setDci(iddci);
		visit.setInterv(idinter);
		visit.setMed(idmed);
		
		visit.setProb(idprob);
		VisitDaoImpl dao = new VisitDaoImpl();
	
	

		
		visit.setUser(idUser);
		dao.insert(visit);
		try {
			visit.setIdv(dao.ExtractIdVisit(visit));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(visit.getIdv());
		dao.insert2(visit);
		dao.insert3(visit);
		dao.insert4(visit);
	}
	
	
	
	public static boolean exist(int id) {
		VisitDaoImpl dao = new VisitDaoImpl();
		
		return dao.exist(id);
	}
}

