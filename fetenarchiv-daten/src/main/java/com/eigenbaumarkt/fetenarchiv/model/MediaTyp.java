package com.eigenbaumarkt.fetenarchiv.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "typen")
public class MediaTyp extends Basis {

    @Builder
    public MediaTyp(Long id, String titel) {
        super(id);
        this.titel = titel;
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
