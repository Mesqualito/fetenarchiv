package com.eigenbaumarkt.fetenarchiv.services.map;

import com.eigenbaumarkt.fetenarchiv.model.Kontakt;
import com.eigenbaumarkt.fetenarchiv.model.Media;
import com.eigenbaumarkt.fetenarchiv.services.KontaktService;
import com.eigenbaumarkt.fetenarchiv.services.MediaService;
import com.eigenbaumarkt.fetenarchiv.services.MediaTypenService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class KontaktServiceMap extends AbstractMapService<Kontakt, Long> implements KontaktService {

    private final MediaTypenService mediaTypenService;
    private final MediaService mediaService;

    public KontaktServiceMap(MediaTypenService mediaTypenService, MediaService mediaService) {
        this.mediaTypenService = mediaTypenService;
        this.mediaService = mediaService;
    }

    @Override
    public Set<Kontakt> findAll() {
        return super.findAll();
    }

    @Override
    public Kontakt findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Kontakt save(Kontakt kontakt) {

        // Defensive Coding:
        // bei abhängigen HashSets Id-Erstellung berücksichtigen
        // (wird in Spring von Hibernate übernommen)
        if(kontakt != null) {
            if (kontakt.getMediaSet() != null){
                kontakt.getMediaSet().forEach(media -> {
                    if(media.getMediaTyp() != null){
                        if(media.getMediaTyp().getId() == null){
                            media.setMediaTyp(mediaTypenService.save(media.getMediaTyp()));
                        }

                    } else {
                        throw new RuntimeException("MediaTyp ist notwendig.");                    }

                    if (media.getId() == null){
                        Media savedMedia = mediaService.save(media);
                        media.setId(savedMedia.getId());
                    }
                });
            }
            return super.save(kontakt);
        } else {
            return null;
        }
    }

    @Override
    public void delete(Kontakt kontakt) {
        super.delete(kontakt);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Kontakt findByLastName(String lastName) {

        // TODO
        return null;

    }

}
