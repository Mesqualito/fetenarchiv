package com.eigenbaumarkt.fetenarchiv.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "typen")
public class MediaTyp extends Basis {

    @Column(name = "titel")
    private String titel;

    @Column(name = "beschreibung")
    private String beschreibung;

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
}
