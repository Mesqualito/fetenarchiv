package com.eigenbaumarkt.fetenarchiv.model;

import java.time.LocalDate;

public class Person extends Basis {

    private String firstName;
    private String lastName;
    private Adresse adresse;
    private LocalDate birthday;
    private RemoteContact rContact;
    private LocalDate creationStamp;
    private LocalDate lastUpdatedStamp;

    public LocalDate getCreationStamp() {
        return creationStamp;
    }

    public void setCreationStamp(LocalDate creationStamp) {
        this.creationStamp = creationStamp;
    }

    public LocalDate getLastUpdatedStamp() {
        return lastUpdatedStamp;
    }

    public void setLastUpdatedStamp(LocalDate lastUpdatedStamp) {
        this.lastUpdatedStamp = lastUpdatedStamp;
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

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public RemoteContact getrContact() {
        return rContact;
    }

    public void setrContact(RemoteContact rContact) {
        this.rContact = rContact;
    }
}
