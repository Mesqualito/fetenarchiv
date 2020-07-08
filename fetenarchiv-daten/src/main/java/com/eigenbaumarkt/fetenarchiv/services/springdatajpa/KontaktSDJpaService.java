package com.eigenbaumarkt.fetenarchiv.services.springdatajpa;

import com.eigenbaumarkt.fetenarchiv.model.Kontakt;
import com.eigenbaumarkt.fetenarchiv.repositories.KontaktRepository;
import com.eigenbaumarkt.fetenarchiv.repositories.MediaRepository;
import com.eigenbaumarkt.fetenarchiv.repositories.MediaTypRepository;
import com.eigenbaumarkt.fetenarchiv.services.KontaktService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class KontaktSDJpaService implements KontaktService {

    private final KontaktRepository kontaktRepository;
    private final MediaRepository mediaRepository;
    private final MediaTypRepository mediaTypRepository;

    public KontaktSDJpaService(KontaktRepository kontaktRepository, MediaRepository mediaRepository, MediaTypRepository mediaTypRepository) {
        this.kontaktRepository = kontaktRepository;
        this.mediaRepository = mediaRepository;
        this.mediaTypRepository = mediaTypRepository;
    }

    @Override
    public Kontakt findByLastName(String lastName) {
        return kontaktRepository.findByLastName(lastName);
    }

    @Override
    public List<Kontakt> findAllByLastNameLike(String lastName) {

        return kontaktRepository.findAllByLastNameLike(lastName);
    }

    @Override
    public Set<Kontakt> findAll() {
        Set<Kontakt> kontaktSet = new HashSet<>();
        kontaktRepository.findAll().forEach(kontaktSet::add);
        return kontaktSet;
    }

    @Override
    public Kontakt findById(Long id) {
        return kontaktRepository.findById(id).orElse(null);
    }

    @Override
    public Kontakt save(Kontakt object) {
        return kontaktRepository.save(object);
    }

    @Override
    public void delete(Kontakt object) {
        kontaktRepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        kontaktRepository.deleteById(id);
    }
}
