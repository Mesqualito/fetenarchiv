package com.eigenbaumarkt.fetenarchiv.services.springdatajpa;

import com.eigenbaumarkt.fetenarchiv.model.Fete;
import com.eigenbaumarkt.fetenarchiv.repositories.FeteRepository;
import com.eigenbaumarkt.fetenarchiv.services.FeteService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class FeteSDJpaService implements FeteService {

    private final FeteRepository feteRepository;

    public FeteSDJpaService(FeteRepository feteRepository) {
        this.feteRepository = feteRepository;
    }

    @Override
    public Set<Fete> findAll() {
        Set<Fete> feteSet = new HashSet<>();
        feteRepository.findAll().forEach(feteSet::add);
        return feteSet;
    }

    @Override
    public Fete findById(Long id) {
        return feteRepository.findById(id).orElse(null);
    }

    @Override
    public Fete save(Fete object) {
        return feteRepository.save(object);
    }

    @Override
    public void delete(Fete object) {
        feteRepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        feteRepository.deleteById(id);
    }
}
