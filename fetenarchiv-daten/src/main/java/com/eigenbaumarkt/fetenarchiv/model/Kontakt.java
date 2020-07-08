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
    public Kontakt(Long id, LocalDate creationStamp, LocalDate lastUpdatedStamp, String firstName, String lastName,
                   LocalDate geburtstag, Adresse adresse, Set<Media> mediaSet) {
        super(id, creationStamp, lastUpdatedStamp, firstName, lastName);
        this.geburtstag = geburtstag;
        this.adresse = adresse;

        if(mediaSet != null) {
            this.mediaSet = mediaSet;
        }
    }

    @Column(name = "geburtstag")
    private LocalDate geburtstag;

    @OneToOne
    private Adresse adresse;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "kontakt")
    private Set<Media> mediaSet = new HashSet<>();

    /**
     * Return the Media with the given name, or null if none found for this Kontakt.
     *
     * @param name to test
     * @return true if media name is already in use
     */
    public Media getMedia(String name) {
        return getMedia(name);
    }

    /*
    public Media getMedia(String name, boolean ignoreNew) {
        name = name.toLowerCase();
        for (Media media : mediaSet) {
            if (!ignoreNew || !media.isNew()) {
                String compName = media.getName();
                compName = compName.toLowerCase();
                if (compName.equals(name)) {
                    return media;
                }
            }
        }
        return null;
    }
    */
}
