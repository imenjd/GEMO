package sample.entities;

public class SearchDetails {
	private String idpatient;
	private String ref;
	private String service;
	private String firstname;
	private String lastname;
	private String contexte;
	private String commentaire;
	private String userfn;
	private String userln;
	private String status;
	private String dci;
	private String med;
	private String intervention;
	private String dbpatient;
	private String date;
	private String probleme;
	
	
	public String getContexte() {
		return contexte;
	}
	
	public String getCommentaire() {
		return commentaire;
	}
	
	public String getUserfn() {
		return userfn;
	}
	
	public String getUserln() {
		return userln;
	}
	
	public String getStatus() {
		return status;
	}
	
	public String getDci() {
		return dci;
	}
	
	public String getMed() {
		return med;
	}
	
	public String getIntervention() {
		return intervention;
	}
	
	public String getDbpatient() {
		return dbpatient;
	}
	
	public String getDate() {
		return date;
	}
	
	public String getProbleme() {
		return probleme;
	}
	
	public String getRef(){
		return ref;
	}
	public void setRef(String ref){
		this.ref=ref;
	}
	public String getIdpatient(){
		return idpatient;
	}
	public void setIdpatient(String id_patient){
		this.idpatient=id_patient;
	}
	public String getFirstname(){
		return firstname;
	}
	public void setFirstname(String firstname){
		this.firstname=firstname;
	}
	public String getLastname(){
		return lastname;
	}
	public void setLastname(String lastname){
		this.lastname=lastname;
	}
	public String getService(){
		return service;
	}
	public void setService(String service){
		this.service=service;
	}
	
	public void setContexte(String contexte) {
		this.contexte = contexte;
	}
	
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
	
	public void setUserfn(String userfn) {
		this.userfn = userfn;
	}
	
	public void setUserln(String userln) {
		this.userln = userln;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public void setDci(String dci) {
		this.dci = dci;
	}
	
	public void setMed(String med) {
		this.med = med;
	}
	
	public void setIntervention(String intervention) {
		this.intervention = intervention;
	}
	
	public void setDbpatient(String dbpatient) {
		this.dbpatient = dbpatient;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public void setProbleme(String probleme) {
		this.probleme = probleme;
	}
}
