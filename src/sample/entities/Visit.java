package sample.entities;

public class Visit {
	
	
	public Visit(){}
	
	
	
	private int user;
	private int idp;
	
	private int idv;
	private String date;
	private int service;
	private int dci;
	private int interv;
	private int prob;
	private int med;
	private String contexte;
	private String commentaire;
	
	public Visit(int user, int idp, String date, int service, int dci, int interv, int prob, int med, String contexte, String commentaire) {
		this.user=user;
		this.idp=idp;
	
		this.idv=idv;
		this.date=date;
		this.service=service;
		this.dci=dci;
		this.interv=interv;
		this.prob=prob;
		this.med=med;
		this.contexte=contexte;
		this.commentaire=commentaire;
	}
	
	public int getUser() {
		return user;
	}
	
	public int getIdp() {
		return idp;
	}
	
	
	public int getIdv() {
		return idv;
	}
	
	public String getDate() {
		return date;
	}
	
	public int getService() {
		return service;
	}
	
	public int getDci() {
		return dci;
	}
	
	public int getInterv() {
		return interv;
	}
	
	public int getProb() {
		return prob;
	}
	
	public int getMed() {
		return med;
	}
	
	public String getContexte() {
		return contexte;
	}
	
	public String getCommentaire() {
		return commentaire;
	}
	
	public void setUser(int user) {
		this.user = user;
	}
	
	public void setIdp(int idp) {
		this.idp = idp;
	}
	
	
	public void setIdv(int idv) {
		this.idv = idv;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public void setService(int service) {
		this.service = service;
	}
	
	public void setDci(int dci) {
		this.dci = dci;
	}
	
	public void setInterv(int interv) {
		this.interv = interv;
	}
	
	public void setProb(int prob) {
		this.prob = prob;
	}
	
	public void setMed(int med) {
		this.med = med;
	}
	
	public void setContexte(String contexte) {
		this.contexte = contexte;
	}
	
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
}
