package com.eigenbaumarkt.fetenarchiv.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Adresse extends Basis {

    @Column(name = "strasse")
    private String strasse;

    @Column(name = "haus_nr")
    private String hausNr;

    @Column(name = "ort")
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
