package com.eigenbaumarkt.fetenarchiv.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "feten")
public class Fete extends Basis {

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

    public LocalDate getStartDatum() {
        return startDatum;
    }

    public void setStartDatum(LocalDate startDatum) {
        this.startDatum = startDatum;
    }

    public LocalDate getEndDatum() {
        return endDatum;
    }

    public void setEndDatum(LocalDate endDatum) {
        this.endDatum = endDatum;
    }

    public Kontakt getKontakt() {
        return kontakt;
    }

    public void setKontakt(Kontakt kontakt) {
        this.kontakt = kontakt;
    }

    public Set<Adresse> getAdressen() {
        return adressen;
    }

    public void setAdressen(Set<Adresse> adressen) {
        this.adressen = adressen;
    }
}
