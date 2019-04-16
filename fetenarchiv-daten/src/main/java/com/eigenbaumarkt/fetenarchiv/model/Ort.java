package com.eigenbaumarkt.fetenarchiv.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "orte")
public class Ort extends Basis {

    @Column(name = "titel")
    private String titel;

    @Column(name = "plz")
    private String plz;

    @Column(name = "region")
    private String region;

    @Column(name = "land")
    private String land;

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getPlz() {
        return plz;
    }

    public void setPlz(String plz) {
        this.plz = plz;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getLand() {
        return land;
    }

    public void setLand(String land) {
        this.land = land;
    }
}
