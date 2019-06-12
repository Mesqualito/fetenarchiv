package com.eigenbaumarkt.fetenarchiv.services.map;

import com.eigenbaumarkt.fetenarchiv.model.Media;
import com.eigenbaumarkt.fetenarchiv.services.MediaService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class MediaMapService extends AbstractMapService<Media, Long> implements MediaService {

    @Override
    public Set<Media> findAll() {
        return super.findAll();
    }

    @Override
    public Media findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Media save(Media media) {
        return super.save(media);
    }

    @Override
    public void delete(Media media) {
        super.delete(media);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
