package tn.medtech.sweng.gemo.entities;

package com.company;

public class Visit {


    private int idp;
    private int ids;
    private String comment;
    private int idu=1;
    private String date;

    public Visit(){

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



    public Visit(int idp, int ids, String comment, String date, int idu){
        this.idp=idp;
        this.ids=ids;
        this.date=date;
        this.comment=comment;
        this.idu=idu;
    }




}

