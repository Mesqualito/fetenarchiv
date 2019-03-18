package com.eigenbaumarkt.fetenarchiv.services.map;

import com.eigenbaumarkt.fetenarchiv.model.MediaTyp;
import com.eigenbaumarkt.fetenarchiv.services.MediaTypenService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class MediaTypenServiceMap extends AbstractMapService<MediaTyp, Long> implements MediaTypenService {

    @Override
    public Set<MediaTyp> findAll() {
        return super.findAll();
    }

    @Override
    public MediaTyp findById(Long id) {
        return super.findById(id);
    }

    @Override
    public MediaTyp save(MediaTyp mediaTyp) {
        return super.save(mediaTyp);
    }

    @Override
    public void delete(MediaTyp mediaTyp) {
        super.delete(mediaTyp);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}