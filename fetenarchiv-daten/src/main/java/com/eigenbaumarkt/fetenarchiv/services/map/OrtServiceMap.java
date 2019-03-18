package com.eigenbaumarkt.fetenarchiv.services.map;

import com.eigenbaumarkt.fetenarchiv.model.Ort;
import com.eigenbaumarkt.fetenarchiv.services.OrtService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class OrtServiceMap extends AbstractMapService<Ort, Long> implements OrtService {

    @Override
    public Set<Ort> findAll() {
        return super.findAll();
    }

    @Override
    public Ort findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Ort save(Ort ort) {
        return super.save(ort);
    }

    @Override
    public void delete(Ort ort) {
        super.delete(ort);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}