package com.eigenbaumarkt.fetenarchiv.model;

import java.io.Serializable;

public class BaseEntity implements Serializable {

    // Recommendation of Hibernate:
    // use Box-Types (not 'long', but 'Long')
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
