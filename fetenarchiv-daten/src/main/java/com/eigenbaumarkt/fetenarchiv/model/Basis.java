package com.eigenbaumarkt.fetenarchiv.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

// die Annotation teilt Spring Data JPA mit,
// dass die Klasse vererbt wird und nicht
// selbst gespeichert zu werden braucht
@MappedSuperclass
public class Basis implements Serializable {

    // Recommendation of Hibernate:
    // use Box-Types (not 'long', but 'Long')
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "creation_stamp")
    private LocalDate creationStamp;

    @Column(name = "last_updated_stamp")
    private LocalDate lastUpdatedStamp;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getCreationStamp() {
        return creationStamp;
    }

    public void setCreationStamp(LocalDate creationStamp) {
        this.creationStamp = creationStamp;
    }

    public LocalDate getLastUpdatedStamp() {
        return lastUpdatedStamp;
    }

    public void setLastUpdatedStamp(LocalDate lastUpdatedStamp) {
        this.lastUpdatedStamp = lastUpdatedStamp;
    }
}
