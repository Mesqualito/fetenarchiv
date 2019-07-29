package com.eigenbaumarkt.fetenarchiv.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class Person extends Basis {

    public Person(Long id, LocalDate creationStamp, LocalDate lastUpdatedStamp, String firstName, String lastName) {
        super(id, creationStamp, lastUpdatedStamp);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // like the default naming strategy
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;
}