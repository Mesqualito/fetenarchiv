package com.eigenbaumarkt.fetenarchiv.services.springdatajpa;

import com.eigenbaumarkt.fetenarchiv.model.Adresse;
import com.eigenbaumarkt.fetenarchiv.repositories.AdresseRepository;
import com.eigenbaumarkt.fetenarchiv.services.AdresseService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class AdresseSDJpaService implements AdresseService {

    private final AdresseRepository adresseRepository;

    public AdresseSDJpaService(AdresseRepository adresseRepository) {
        this.adresseRepository = adresseRepository;
    }

    @Override
    public Set<Adresse> findAll() {
        Set<Adresse> adressen = new HashSet<>();
        adresseRepository.findAll().forEach(adressen::add);
        return adressen;
    }

    @Override
    public Adresse findById(Long id) {
        return adresseRepository.findById(id).orElse(null);
    }

    @Override
    public Adresse save(Adresse object) {
        return adresseRepository.save(object);
    }

    @Override
    public void delete(Adresse object) {
adresseRepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
adresseRepository.deleteById(id);
    }
}