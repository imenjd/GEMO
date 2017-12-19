package tn.medtech.sweng.gemo.entities;

public class Visit {


    public Visit(int id, int idp, int ids, String comment, int idu, String date, int idd, int idi, String context, int idpb) {
        this.id = id;
        this.idp = idp;
        this.ids = ids;
        this.comment = comment;
        this.idu = idu;
        this.date = date;
        this.idd = idd;
        this.idi = idi;
        this.context = context;
        this.idpb = idpb;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id;
    private int idp;
    private int ids;
    private String comment;
    private int idu = 1; // session id of the connected user
    private String date;
    private int idd;
    private int idi;
    private String context;
    private int idpb;

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    private int userid;

    public int getIdpb() {
        return idpb;
    }

    public void setIdpb(int idpb) {
        this.idpb = idpb;
    }




    public Visit() {

    }

    public int getIdd() {
        return idd;
    }

    public void setIdd(int idd) {
        this.idd = idd;
    }

    public int getIdi() {
        return idi;
    }

    public void setIdi(int idi) {
        this.idi = idi;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public int getIdp() {
        return idp;
    }

    public void setIdp(int idp) {
        this.idp = idp;
    }

    public int getIds() {
        return ids;
    }

    public void setIds(int ids) {
        this.ids = ids;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getIdu() {
        return idu;
    }

    public void setIdu(int idu) {
        this.idu = idu;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }




}