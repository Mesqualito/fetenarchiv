package com.eigenbaumarkt.fetenarchiv.services.map;

import com.eigenbaumarkt.fetenarchiv.model.Kontakt;
import com.eigenbaumarkt.fetenarchiv.model.Media;
import com.eigenbaumarkt.fetenarchiv.services.KontaktService;
import com.eigenbaumarkt.fetenarchiv.services.MediaService;
import com.eigenbaumarkt.fetenarchiv.services.MediaTypService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@Profile({"default", "map"})
public class KontaktMapService extends AbstractMapService<Kontakt, Long> implements KontaktService {

    private final MediaTypService mediaTypService;
    private final MediaService mediaService;

    public KontaktMapService(MediaTypService mediaTypService, MediaService mediaService) {
        this.mediaTypService = mediaTypService;
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
                            media.setMediaTyp(mediaTypService.save(media.getMediaTyp()));
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
        // Java 8 'stream':
        return this.findAll()
                .stream()
                .filter(kontakt -> kontakt.getLastName().equalsIgnoreCase(lastName))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Kontakt> findAllByLastNameLike(String lastName) {

        // ToDo: implement method for map
        return null;
    }
}
