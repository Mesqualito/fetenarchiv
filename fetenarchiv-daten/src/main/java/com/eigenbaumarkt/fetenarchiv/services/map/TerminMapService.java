package com.eigenbaumarkt.fetenarchiv.services.map;

import com.eigenbaumarkt.fetenarchiv.model.Termin;
import com.eigenbaumarkt.fetenarchiv.services.TerminService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
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
        /* TODO: durch die Medien-Objekte im MediaSet iterieren,
         * Runtime.exception werfen bei:
         * - media.getKontakt() == null oder
         * - media.getId() == null oder
         * - media.getKontakt().getId() == null
         */
        if(termin.getMediaSet() == null ){
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