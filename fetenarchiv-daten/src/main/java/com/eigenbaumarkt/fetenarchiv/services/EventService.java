package com.eigenbaumarkt.fetenarchiv.services;

import com.eigenbaumarkt.fetenarchiv.model.Event;

import java.util.Set;

public interface EventService {

    Event findById(Long id);

    Event save(Event event);

    Set<Event> findAll();
}
