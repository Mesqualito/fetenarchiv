package com.eigenbaumarkt.fetenarchiv.services;

import com.eigenbaumarkt.fetenarchiv.model.Kontakt;

import java.util.Set;

public interface KontaktService extends CrudService<Kontakt, Long> {

    Set<Kontakt> findByLastName(String lastName);

}
