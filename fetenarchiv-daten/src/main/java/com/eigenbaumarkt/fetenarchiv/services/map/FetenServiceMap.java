package com.eigenbaumarkt.fetenarchiv.services.map;

import com.eigenbaumarkt.fetenarchiv.model.Fete;
import com.eigenbaumarkt.fetenarchiv.services.FetenService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class FetenServiceMap extends AbstractMapService<Fete, Long> implements FetenService {

    @Override
    public Set<Fete> findAll() {
        return super.findAll();
    }

    @Override
    public Fete findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Fete save(Fete fete) {
        return super.save(fete);
    }

    @Override
    public void delete(Fete fete) {
        super.delete(fete);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}