package com.eigenbaumarkt.fetenarchiv.model;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "termine")
public class Termin extends Basis {

    @Builder
    public Termin(Long id, String titel, LocalDate datum, Media media, Timestamp creationStamp, Timestamp lastUpdatedStamp) {
        super(id, creationStamp, lastUpdatedStamp);
        this.titel = titel;
        this.datum = datum;
        this.media = media;
    }

    @Column(name = "titel")
    private String titel;

    @Column(name = "datum")
    private LocalDate datum;

    @OneToOne
    private Kontakt kontakt;

    @ManyToOne
    @JoinColumn(name = "media_id")
    private Media media;

}
