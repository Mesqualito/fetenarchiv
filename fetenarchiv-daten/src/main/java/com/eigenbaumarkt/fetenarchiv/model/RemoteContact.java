package com.eigenbaumarkt.fetenarchiv.model;

import java.time.LocalDate;

public class RemoteContact {

    private String title;
    private RcType rcType;
    private String contact;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public RcType getRcType() {
        return rcType;
    }

    public void setRcType(RcType rcType) {
        this.rcType = rcType;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
