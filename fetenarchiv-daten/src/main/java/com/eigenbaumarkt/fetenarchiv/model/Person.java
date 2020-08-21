package com.eigenbaumarkt.fetenarchiv.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
public class Person extends Basis {

    public Person(Long id, Timestamp creationStamp, Timestamp lastUpdatedStamp, String firstName, String lastName) {
        super(id, creationStamp, lastUpdatedStamp);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;
}
