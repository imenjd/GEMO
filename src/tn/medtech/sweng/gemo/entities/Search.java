package tn.medtech.sweng.gemo.entities;

import javafx.beans.property.SimpleStringProperty;
public class Search {
    private String idpatient;
    private String ref;
    private String service;
    private String firstname;
    private String lastname;


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


}

