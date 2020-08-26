package com.eigenbaumarkt.fetenarchiv.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Calendar;

@Getter
@Setter
@NoArgsConstructor
// die Annotation teilt Spring Data JPA mit,
// dass die Klasse vererbt wird und nicht
// selbst gespeichert zu werden braucht
@MappedSuperclass
public class Basis implements Serializable {

    public Basis(Long id, Timestamp creationStamp, Timestamp lastUpdatedStamp) {
        this.id = id;
        this.creationStamp = getTimeStampNow();
        this.lastUpdatedStamp = this.getLastUpdatedStamp();
    }

    // Recommendation of Hibernate:
    // use Box-Types (not 'long', but 'Long')
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "creation_stamp")
    private Timestamp creationStamp;

    @Column(name = "last_updated_stamp")
    private Timestamp lastUpdatedStamp;

    // Exception evaluating SpringEL expression: "kontakt['new']" (template: "kontakte/kontaktAnlegenOderUpdatenForm")
    // bzw. 'th:if="${media['new']}"' (template: "medien/mediaAnlegenOderAendernForm.html")
    // Evaluierung für die Buttons "... neu" oder "... ändern" schlägt fehl ohne:
    public boolean isNew() {
        return this.id == null;
    }

    public Timestamp getTimeStampNow() {
        return new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());
    }

}
