package com.eigenbaumarkt.fetenarchiv.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "adressen")
public class Adresse extends Basis {

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
