package com.eigenbaumarkt.fetenarchiv.model;

import java.time.LocalDate;
import java.util.Set;

public class Kontakt extends Person {

    private LocalDate creationStamp;
    private LocalDate lastUpdatedStamp;
    private Set<Media> mediaSet;
    private Set<Fete> fetenSet;

    @Override
    public LocalDate getCreationStamp() {
        return creationStamp;
    }

    @Override
    public void setCreationStamp(LocalDate creationStamp) {
        this.creationStamp = creationStamp;
    }

    @Override
    public LocalDate getLastUpdatedStamp() {
        return lastUpdatedStamp;
    }

    @Override
    public void setLastUpdatedStamp(LocalDate lastUpdatedStamp) {
        this.lastUpdatedStamp = lastUpdatedStamp;
    }

    public Set<Media> getMediaSet() {
        return mediaSet;
    }

    public void setMediaSet(Set<Media> mediaSet) {
        this.mediaSet = mediaSet;
    }

    public Set<Fete> getFetenSet() {
        return fetenSet;
    }

    public void setFetenSet(Set<Fete> fetenSet) {
        this.fetenSet = fetenSet;
    }
}
