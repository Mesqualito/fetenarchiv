package com.eigenbaumarkt.fetenarchiv.model;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "medien")
public class Media extends Basis {

    @Builder
    public Media(Long id, String titel, MediaTyp mediaTyp, Kontakt kontakt, Set<Termin> terminSet, Timestamp creationStamp, Timestamp lastUpdatedStamp) {
        super(id, creationStamp, lastUpdatedStamp);
        this.titel = titel;
        this.mediaTyp = mediaTyp;
        this.kontakt = kontakt;

        if (terminSet == null || terminSet.size() > 0) {
            this.terminSet = terminSet;
        }

    }

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

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "media")
    private Set<Termin> terminSet = new HashSet<>();

}
