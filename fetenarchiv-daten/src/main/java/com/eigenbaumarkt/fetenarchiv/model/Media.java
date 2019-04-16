package com.eigenbaumarkt.fetenarchiv.model;

import javax.persistence.*;

@Entity
@Table(name = "medien")
public class Media extends Basis {

    @Column(name = "titel")
    private String titel;

    @Column(name = "beschreibung")
    private String beschreibung;

    @ManyToOne
    @JoinColumn(name = "typ_id")
    private MediaTyp mediaTyp;

    @ManyToOne
    @JoinColumn(name = "kontakt_id")
    private Kontakt kontakt;

    @ManyToOne
    @JoinColumn(name = "termin_id")
    private Termin termin;

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public MediaTyp getMediaTyp() {
        return mediaTyp;
    }

    public void setMediaTyp(MediaTyp mediaTyp) {
        this.mediaTyp = mediaTyp;
    }

    public Kontakt getKontakt() {
        return kontakt;
    }

    public void setKontakt(Kontakt kontakt) {
        this.kontakt = kontakt;
    }

    public Termin getTermin() {
        return termin;
    }

    public void setTermin(Termin termin) {
        this.termin = termin;
    }


}
