package com.eigenbaumarkt.fetenarchiv.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "kontakte")
public class Kontakt extends Person {

    @Column(name = "geburtstag")
    private LocalDate geburtstag;

    @OneToOne
    private Adresse adresse;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "kontakt")
    private Set<Media> mediaSet = new HashSet<>();

    public Set<Media> getMediaSet() {
        return mediaSet;
    }

    public void setMediaSet(Set<Media> mediaSet) {
        this.mediaSet = mediaSet;
    }

    public LocalDate getGeburtstag() {
        return geburtstag;
    }

    public void setGeburtstag(LocalDate geburtstag) {
        this.geburtstag = geburtstag;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }


}
