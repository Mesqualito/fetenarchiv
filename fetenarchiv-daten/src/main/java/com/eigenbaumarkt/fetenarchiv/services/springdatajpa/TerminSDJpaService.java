package com.eigenbaumarkt.fetenarchiv.services.springdatajpa;

import com.eigenbaumarkt.fetenarchiv.model.Termin;
import com.eigenbaumarkt.fetenarchiv.repositories.TerminRepository;
import com.eigenbaumarkt.fetenarchiv.services.TerminService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class TerminSDJpaService implements TerminService {

    private final TerminRepository terminRepository;

    public TerminSDJpaService(TerminRepository terminRepository) {
        this.terminRepository = terminRepository;
    }

    @Override
    public Set<Termin> findAll() {
        Set<Termin> termine = new HashSet<>();
        terminRepository.findAll().forEach(termine::add);
        return termine;
    }

    @Override
    public Termin findById(Long id) {
        return terminRepository.findById(id).orElse(null);
    }

    @Override
    public Termin save(Termin object) {
        return terminRepository.save(object);
    }

    @Override
    public void delete(Termin object) {
        terminRepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
terminRepository.deleteById(id);
    }
}