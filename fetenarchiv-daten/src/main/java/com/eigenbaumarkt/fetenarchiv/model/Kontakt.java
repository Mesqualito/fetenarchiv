package com.eigenbaumarkt.fetenarchiv.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "kontakte")
public class Kontakt extends Person {

    @Builder
    public Kontakt(Long id, LocalDate creationStamp, LocalDate lastUpdatedStamp, String firstName, String lastName, LocalDate geburtstag, Adresse adresse, Set<Media> mediaSet) {
        super(id, creationStamp, lastUpdatedStamp, firstName, lastName);
        this.geburtstag = geburtstag;
        this.adresse = adresse;
        this.mediaSet = mediaSet;
    }

    @Column(name = "geburtstag")
    private LocalDate geburtstag;

    @OneToOne
    private Adresse adresse;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "kontakt")
    private Set<Media> mediaSet = new HashSet<>();
}
