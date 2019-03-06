package com.eigenbaumarkt.fetenarchiv.services;

import com.eigenbaumarkt.fetenarchiv.model.Media;

import java.util.Set;

public interface MediaService {

    Media findById(Long id);

    Media save(Media media);

    Set<Media> findAll();
}
