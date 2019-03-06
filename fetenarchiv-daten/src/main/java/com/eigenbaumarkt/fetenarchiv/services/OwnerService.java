package com.eigenbaumarkt.fetenarchiv.services;

import com.eigenbaumarkt.fetenarchiv.model.Owner;

import java.util.Set;

public interface OwnerService {

    Set<Owner> findByLastName(String lastName);

    Owner findById(Long id);

    Owner save(Owner owner);

    Set<Owner> findAll();
}
