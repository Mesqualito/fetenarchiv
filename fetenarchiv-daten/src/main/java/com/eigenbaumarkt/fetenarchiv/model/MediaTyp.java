package com.eigenbaumarkt.fetenarchiv.model;

import java.time.LocalDate;

public class MediaTyp extends Basis {

    private String title;
    private String description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
