package com.eigenbaumarkt.fetenarchiv.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
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

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ort")
    private Set<Adresse> adresseSet = new HashSet<>();

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

    public Set<Adresse> getAdresseSet() {
        return adresseSet;
    }

    public void setAdresseSet(Set<Adresse> adresseSet) {
        this.adresseSet = adresseSet;
    }
}
