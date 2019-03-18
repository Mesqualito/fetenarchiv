package com.eigenbaumarkt.fetenarchiv.services.map;

import com.eigenbaumarkt.fetenarchiv.model.Kontakt;
import com.eigenbaumarkt.fetenarchiv.services.KontaktService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class KontaktServiceMap extends AbstractMapService<Kontakt, Long> implements KontaktService {

    @Override
    public Set<Kontakt> findAll() {
        return super.findAll();
    }

    @Override
    public Kontakt findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Kontakt save(Kontakt kontakt) {
        return super.save(kontakt);
    }

    @Override
    public void delete(Kontakt kontakt) {
        super.delete(kontakt);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Set<Kontakt> findByLastName(String lastName) {

        // TODO
        return null;

    }

}
