package com.eigenbaumarkt.fetenarchiv.services.map;

import com.eigenbaumarkt.fetenarchiv.model.Termin;
import com.eigenbaumarkt.fetenarchiv.services.TerminService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class TerminMapService extends AbstractMapService<Termin, Long> implements TerminService {

    @Override
    public Set<Termin> findAll() {
        return super.findAll();
    }

    @Override
    public Termin findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Termin save(Termin termin) {
        if(termin.getKontakt() == null || termin.getKontakt().getId() == null){
            throw new RuntimeException("Ungültiger Termin!");
        }
        return super.save(termin);
    }

    @Override
    public void delete(Termin termin) {
        super.delete(termin);
    }

    @Override
    public void deleteById(Long id) {
super.deleteById(id);
    }
}