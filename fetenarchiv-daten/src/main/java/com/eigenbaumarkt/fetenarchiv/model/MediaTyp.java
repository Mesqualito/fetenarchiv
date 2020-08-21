package com.eigenbaumarkt.fetenarchiv.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "typen")
public class MediaTyp extends Basis {

    @Builder
    public MediaTyp(Long id, String titel, String beschreibung, Timestamp creationStamp, Timestamp lastUpdatedStamp) {
        super(id, creationStamp, lastUpdatedStamp);
        this.titel = titel;
        this.beschreibung = beschreibung;
    }

    @Column(name = "titel")
    private String titel;

    @Column(name = "beschreibung")
    private String beschreibung;

    @Override
    public String toString() {
        return titel;
    }
}
