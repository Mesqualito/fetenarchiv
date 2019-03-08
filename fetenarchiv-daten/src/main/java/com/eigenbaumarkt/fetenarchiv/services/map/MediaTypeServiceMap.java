package com.eigenbaumarkt.fetenarchiv.services.map;

import com.eigenbaumarkt.fetenarchiv.model.MediaType;
import com.eigenbaumarkt.fetenarchiv.services.MediaTypeService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class MediaTypeServiceMap extends AbstractMapService<MediaType, Long> implements MediaTypeService {

    @Override
    public Set<MediaType> findAll() {
        return super.findAll();
    }

    @Override
    public MediaType findById(Long id) {
        return super.findById(id);
    }

    @Override
    public MediaType save(MediaType mediaType) {
        return super.save(mediaType.getId(), mediaType);
    }

    @Override
    public void delete(MediaType mediaType) {
        super.delete(mediaType);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}