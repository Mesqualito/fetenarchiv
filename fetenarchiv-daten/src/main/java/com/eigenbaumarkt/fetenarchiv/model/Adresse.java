package com.eigenbaumarkt.fetenarchiv.model;

import lombok.*;
import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "adressen")
public class Adresse extends Basis {

    @Builder
    public Adresse(Long id, Kontakt kontakt, String strasse, String hausNr, Ort ort, Timestamp creationStamp, Timestamp lastUpdatedStamp) {
        super(id, creationStamp, lastUpdatedStamp);
        this.kontakt = kontakt;
        this.strasse = strasse;
        this.hausNr = hausNr;
        this.ort = ort;
    }

    @OneToOne
    private Kontakt kontakt;

    @Column(name = "strasse")
    private String strasse;

    @Column(name = "haus_nr")
    private String hausNr;

    @ManyToOne
    @JoinColumn(name = "ort_id")
    private Ort ort;
}

