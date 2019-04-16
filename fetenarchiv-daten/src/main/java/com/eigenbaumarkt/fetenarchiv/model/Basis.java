package com.eigenbaumarkt.fetenarchiv.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
