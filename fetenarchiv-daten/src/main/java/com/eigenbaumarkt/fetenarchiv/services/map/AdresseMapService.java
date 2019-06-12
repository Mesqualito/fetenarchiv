package com.eigenbaumarkt.fetenarchiv.services.map;

import com.eigenbaumarkt.fetenarchiv.model.Adresse;
import com.eigenbaumarkt.fetenarchiv.services.AdresseService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class AdresseMapService extends AbstractMapService<Adresse, Long> implements AdresseService {

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