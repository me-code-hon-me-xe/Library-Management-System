package a1_2001040023;

import common.PatronType;

import java.util.Date;

public class Patron {
    private String patronID;
    private String name;
    private Date dob;
    private String email;
    private String phoneNumber;
    private PatronType patronType;

    public Patron(String patronID, String name, Date dob, String email, String phoneNumber, PatronType patronType) {
        this.patronID = patronID;
        this.name = name;
        this.dob = dob;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.patronType = patronType;
    }

    public static void generatePatronID(){}

    public String getPatronID() {
        return patronID;
    }

    public void setPatronID(String patronID) {
        this.patronID = patronID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public PatronType getPatronType() {
        return patronType;
    }

    public void setPatronType(PatronType patronType) {
        this.patronType = patronType;
    }
}
