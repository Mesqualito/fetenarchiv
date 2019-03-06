package com.eigenbaumarkt.fetenarchiv.services.map;

import com.eigenbaumarkt.fetenarchiv.model.Event;
import com.eigenbaumarkt.fetenarchiv.services.CrudService;

import java.util.Set;

public class EventServiceMap extends AbstractMapService<Event, Long> implements CrudService<Event, Long> {

    @Override
    public Set<Event> findAll() {
        return super.findAll();
    }

    @Override
    public Event findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Event save(Event event) {
        return super.save(event.getId(), event);
    }

    @Override
    public void delete(Event event) {
        super.delete(event);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}