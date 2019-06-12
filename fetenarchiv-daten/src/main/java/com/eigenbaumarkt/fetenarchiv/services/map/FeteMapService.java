package com.eigenbaumarkt.fetenarchiv.services.map;

import com.eigenbaumarkt.fetenarchiv.model.Fete;
import com.eigenbaumarkt.fetenarchiv.services.FeteService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class FeteMapService extends AbstractMapService<Fete, Long> implements FeteService {

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