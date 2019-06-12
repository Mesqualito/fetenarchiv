package com.eigenbaumarkt.fetenarchiv.services.map;

import com.eigenbaumarkt.fetenarchiv.model.MediaTyp;
import com.eigenbaumarkt.fetenarchiv.services.MediaTypService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class MediaTypMapService extends AbstractMapService<MediaTyp, Long> implements MediaTypService {

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