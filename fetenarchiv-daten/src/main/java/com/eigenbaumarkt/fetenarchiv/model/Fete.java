package com.eigenbaumarkt.fetenarchiv.model;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "feten")
public class Fete extends Basis {

    @Builder
    public Fete(Long id, String titel, String beschreibung, LocalDate startDatum, LocalDate endDatum, Set<Adresse> adressen,
                Kontakt kontakt, Timestamp creationStamp, Timestamp lastUpdatedStamp) {
        super(id, creationStamp, lastUpdatedStamp);
        this.titel = titel;
        this.beschreibung = beschreibung;
        this.startDatum = startDatum;
        this.endDatum = endDatum;
        this.adressen = adressen;
        this.kontakt = kontakt;
    }

    @Column(name = "titel")
    private String titel;

    @Column(name = "beschreibung")
    private String beschreibung;

    @Column(name = "start_datum")
    private LocalDate startDatum;

    @Column(name = "end_datum")
    private LocalDate endDatum;

    // EAGER sorgt dafür, dass die Daten
    // auch vor eigentlichen Anfragen geladen werden
    // andernfalls wäre die adresse "null"
    // wenn fete geladen wird
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "feten_adressen",
            joinColumns = @JoinColumn(name = "fete_id"),
            inverseJoinColumns = @JoinColumn(name = "adresse_id"))
    private Set<Adresse> adressen = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "kontakt_id")
    private Kontakt kontakt;

}
