package com.eigenbaumarkt.fetenarchiv.model;

import javax.persistence.*;

@Entity
@Table(name = "adressen")
public class Adresse extends Basis {

    @Column(name = "strasse")
    private String strasse;

    @Column(name = "haus_nr")
    private String hausNr;

    @ManyToOne
    @JoinColumn(name = "ort_id")
    private Ort ort;

    public String getStrasse() {
        return strasse;
    }

    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }

    public String getHausNr() {
        return hausNr;
    }

    public void setHausNr(String hausNr) {
        this.hausNr = hausNr;
    }

    public Ort getOrt() {
        return ort;
    }

    public void setOrt(Ort ort) {
        this.ort = ort;
    }
}
