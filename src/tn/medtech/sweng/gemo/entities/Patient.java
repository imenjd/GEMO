package tn.medtech.sweng.gemo.entities;

public class Patient {

    private String firstName;
    private String lastName;
    private String birthDate;

    public Patient(){

    }

    public Patient(String firstName, String lastName, String birthDate){

        this.firstName = firstName;
        this.lastName=lastName;
        this.birthDate=birthDate;
    }




    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }


}
