package com.eigenbaumarkt.fetenarchiv.services;

import com.eigenbaumarkt.fetenarchiv.model.Owner;

import java.util.Set;

public interface OwnerService extends CrudService<Owner, Long> {

    Set<Owner> findByLastName(String lastName);

}
