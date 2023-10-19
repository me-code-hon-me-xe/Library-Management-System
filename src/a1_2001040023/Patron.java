package a1_2001040023;

import com.sun.source.tree.ReturnTree;
import common.PatronType;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Patron {
    private String patronID;
    private String name;
    private Date dob;
    private String email;
    private String phoneNumber;
    private PatronType patronType;
    private static int patronCounter = 1; // To track the number of patrons


    public static void main(String[] args) throws ParseException {
        Patron[] patrons = new Patron[10];

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        patrons[0] = new Patron("Alice Johnson", dateFormat.parse("1990-01-15"), "alice@example.com", "555-1234", PatronType.REGULAR);
        patrons[1] = new Patron("Bob Smith", dateFormat.parse("1985-08-30"), "bob@example.com", "555-5678", PatronType.PREMIUM);
        patrons[2] = new Patron("Charlie Brown", dateFormat.parse("1995-03-22"), "charlie@example.com", "555-9876", PatronType.REGULAR);
        patrons[3] = new Patron("David Lee", dateFormat.parse("1980-12-05"), "david@example.com", "555-4567", PatronType.PREMIUM);
        patrons[4] = new Patron("Eve Wilson", dateFormat.parse("2000-07-10"), "eve@example.com", "555-7890", PatronType.REGULAR);
        patrons[5] = new Patron("Frank Davis", dateFormat.parse("1998-04-28"), "frank@example.com", "555-2345", PatronType.PREMIUM);
        patrons[6] = new Patron("Grace Martinez", dateFormat.parse("1992-11-17"), "grace@example.com", "555-7891", PatronType.REGULAR);
        patrons[7] = new Patron("Henry Taylor", dateFormat.parse("1987-06-12"), "henry@example.com", "555-1235", PatronType.PREMIUM);
        patrons[8] = new Patron("Isabella White", dateFormat.parse("2005-09-25"), "isabella@example.com", "555-4568", PatronType.REGULAR);
        patrons[9] = new Patron("Jack Harris", dateFormat.parse("1996-02-20"), "jack@example.com", "555-9877", PatronType.PREMIUM);

        for(int i = 0, length = patrons.length; i < length; i++){
            System.out.println(patrons[i].patronID);
        }
    }

    public Patron(String name, Date dob, String email, String phoneNumber, PatronType patronType) {

        this.name = name;
        this.dob = dob;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.patronType = patronType;

        // Automatically generate patronID when creating a new patron
        this.patronID = generatePatronID();
    }



    public String generatePatronID(){
        String patronID = String.format("%03d",patronCounter);
        patronCounter++;
        return patronID;
    }

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
