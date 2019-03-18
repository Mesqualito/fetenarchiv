package com.eigenbaumarkt.fetenarchiv.services.map;

import com.eigenbaumarkt.fetenarchiv.model.Adresse;
import com.eigenbaumarkt.fetenarchiv.services.AdressenService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class AdressenServiceMap extends AbstractMapService<Adresse, Long> implements AdressenService {

    @Override
    public Set<Adresse> findAll() {
        return super.findAll();
    }

    @Override
    public Adresse findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Adresse save(Adresse adresse) {
        return super.save(adresse);
    }

    @Override
    public void delete(Adresse adresse) {
        super.delete(adresse);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}