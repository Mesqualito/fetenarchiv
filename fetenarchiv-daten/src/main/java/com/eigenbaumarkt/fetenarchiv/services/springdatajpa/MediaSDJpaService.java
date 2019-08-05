package com.eigenbaumarkt.fetenarchiv.services.springdatajpa;

import com.eigenbaumarkt.fetenarchiv.model.Media;
import com.eigenbaumarkt.fetenarchiv.repositories.MediaRepository;
import com.eigenbaumarkt.fetenarchiv.services.MediaService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class MediaSDJpaService implements MediaService {

    private final MediaRepository mediaRepository;

    public MediaSDJpaService(MediaRepository mediaRepository) {
        this.mediaRepository = mediaRepository;
    }

    @Override
    public Set<Media> findAll() {
        Set<Media> medien = new HashSet<>();
        mediaRepository.findAll().forEach(medien::add);
        return medien;
    }

    @Override
    public Media findById(Long id) {
        return mediaRepository.findById(id).orElse(null);
    }

    @Override
    public Media save(Media object) {
        return mediaRepository.save(object);
    }

    @Override
    public void delete(Media object) {
        mediaRepository.delete(object);

    }

    @Override
    public void deleteById(Long id) {
        mediaRepository.deleteById(id);

    }
}