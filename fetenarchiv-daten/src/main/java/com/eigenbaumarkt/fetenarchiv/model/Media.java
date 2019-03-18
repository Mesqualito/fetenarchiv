package com.eigenbaumarkt.fetenarchiv.model;

import java.time.LocalDate;

public class Media extends Basis {

    private String title;
    private String description;
    private MediaTyp mediaTyp;
    private Kontakt kontakt;
    private Person contactPerson;
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


    public Kontakt getKontakt() {
        return kontakt;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setKontakt(Kontakt kontakt) {
        this.kontakt = kontakt;
    }

    public Person getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(Person contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public MediaTyp getMediaTyp() {
        return mediaTyp;
    }

    public void setMediaTyp(MediaTyp mediaTyp) {
        this.mediaTyp = mediaTyp;
    }
}
