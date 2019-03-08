package com.eigenbaumarkt.fetenarchiv.services.map;

import com.eigenbaumarkt.fetenarchiv.model.Place;
import com.eigenbaumarkt.fetenarchiv.services.PlaceService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PlaceServiceMap extends AbstractMapService<Place, Long> implements PlaceService {

    @Override
    public Set<Place> findAll() {
        return super.findAll();
    }

    @Override
    public Place findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Place save(Place place) {
        return super.save(place);
    }

    @Override
    public void delete(Place place) {
        super.delete(place);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}