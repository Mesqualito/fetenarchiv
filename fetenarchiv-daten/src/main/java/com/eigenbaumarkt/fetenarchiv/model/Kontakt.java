package com.eigenbaumarkt.fetenarchiv.model;

import java.time.LocalDate;
import java.util.Set;

public class Kontakt extends Person {

    private LocalDate creationStamp;
    private LocalDate lastUpdatedStamp;
    private Set<Media> mediaSet;

    public Set<Media> getMediaSet() {
        return mediaSet;
    }

    public void setMediaSet(Set<Media> mediaSet) {
        this.mediaSet = mediaSet;
    }

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


}
