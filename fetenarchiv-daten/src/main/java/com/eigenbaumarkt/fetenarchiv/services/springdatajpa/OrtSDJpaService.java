package com.eigenbaumarkt.fetenarchiv.services.springdatajpa;

import com.eigenbaumarkt.fetenarchiv.model.Ort;
import com.eigenbaumarkt.fetenarchiv.repositories.OrtRepository;
import com.eigenbaumarkt.fetenarchiv.services.OrtService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class OrtSDJpaService implements OrtService {

    private final OrtRepository ortRepository;

    public OrtSDJpaService(OrtRepository ortRepository) {
        this.ortRepository = ortRepository;
    }

    @Override
    public Set<Ort> findAll() {
        Set<Ort> orte = new HashSet<>();
        ortRepository.findAll().forEach(orte::add);
        return orte;
    }

    @Override
    public Ort findById(Long id) {
        return ortRepository.findById(id).orElse(null);
    }

    @Override
    public Ort save(Ort object) {
        return ortRepository.save(object);
    }

    @Override
    public void delete(Ort object) {
ortRepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        ortRepository.deleteById(id);
    }
}