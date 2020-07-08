package com.eigenbaumarkt.fetenarchiv.services;

import com.eigenbaumarkt.fetenarchiv.model.Kontakt;

import java.util.List;

public interface KontaktService extends CrudService<Kontakt, Long> {

    Kontakt findByLastName(String lastName);

    List<Kontakt> findAllByLastNameLike(String lastName);
}
