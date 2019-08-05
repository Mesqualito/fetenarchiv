package com.eigenbaumarkt.fetenarchiv.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "medien")
public class Media extends Basis {

    @Column(name = "titel")
    private String titel;

    @Column(name = "beschreibung")
    private String beschreibung;

    @ManyToOne
    @JoinColumn(name = "typ_id")
    private MediaTyp mediaTyp;

    @ManyToOne
    @JoinColumn(name = "kontakt_id")
    private Kontakt kontakt;

    @ManyToOne
    @JoinColumn(name = "termin_id")
    private Termin termin;
}
