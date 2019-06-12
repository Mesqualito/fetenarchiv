package com.eigenbaumarkt.fetenarchiv.services.map;

import com.eigenbaumarkt.fetenarchiv.model.MediaTyp;
import com.eigenbaumarkt.fetenarchiv.repositories.MediaTypRepository;
import com.eigenbaumarkt.fetenarchiv.services.MediaTypService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class MediaTypSDJpaService implements MediaTypService {

    private final MediaTypRepository mediaTypRepository;

    public MediaTypSDJpaService(MediaTypRepository mediaTypRepository) {
        this.mediaTypRepository = mediaTypRepository;
    }

    @Override
    public Set<MediaTyp> findAll() {
        Set<MediaTyp> mediaTypes = new HashSet<>();
        mediaTypRepository.findAll().forEach(mediaTypes::add);
        return mediaTypes;
    }

    @Override
    public MediaTyp findById(Long id) {
        return mediaTypRepository.findById(id).orElse(null);
    }

    @Override
    public MediaTyp save(MediaTyp object) {
        return mediaTypRepository.save(object);
    }

    @Override
    public void delete(MediaTyp object) {
        mediaTypRepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        mediaTypRepository.deleteById(id);
    }
}