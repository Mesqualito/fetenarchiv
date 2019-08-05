package com.eigenbaumarkt.fetenarchiv.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "termine")
public class Termin extends Basis {

    @Column(name = "titel")
    private String titel;

    @Column(name = "datum")
    private LocalDate datum;

    @OneToOne
    private Kontakt kontakt;
}
