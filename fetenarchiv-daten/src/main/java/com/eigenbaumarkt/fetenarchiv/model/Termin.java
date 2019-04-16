package com.eigenbaumarkt.fetenarchiv.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "termine")
public class Termin extends Basis {

    @Column(name = "titel")
    private String titel;

    @Column(name = "datum")
    private LocalDate datum;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "termin")
    private Set<Media> mediaSet;

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }

    public Set<Media> getMediaSet() {
        return mediaSet;
    }

    public void setMediaSet(Set<Media> mediaSet) {
        this.mediaSet = mediaSet;
    }


}
