package com.eigenbaumarkt.fetenarchiv.repositories;

import com.eigenbaumarkt.fetenarchiv.model.Kontakt;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface KontaktRepository extends CrudRepository<Kontakt, Long> {

    Kontakt findByLastName(String lastName);

    List<Kontakt> findAllByLastNameLike(String lastName);

}
