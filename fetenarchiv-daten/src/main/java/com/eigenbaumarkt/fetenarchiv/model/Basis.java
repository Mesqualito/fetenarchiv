package com.eigenbaumarkt.fetenarchiv.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

// Projekt Lombok
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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

}
