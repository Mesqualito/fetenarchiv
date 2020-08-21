package com.eigenbaumarkt.fetenarchiv.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.sql.Timestamp;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "orte")
public class Ort extends Basis {

    @Builder
    public Ort(Long id, String titel, String plz, String region, String land, Timestamp creationStamp, Timestamp lastUpdatedStamp) {
        super(id, creationStamp, lastUpdatedStamp);
        this.titel = titel;
        this.plz = plz;
        this.region = region;
        this.land = land;
    }

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
}
