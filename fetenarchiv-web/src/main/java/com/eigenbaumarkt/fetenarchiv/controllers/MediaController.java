package com.eigenbaumarkt.fetenarchiv.controllers;

import com.eigenbaumarkt.fetenarchiv.model.Kontakt;
import com.eigenbaumarkt.fetenarchiv.model.MediaTyp;
import com.eigenbaumarkt.fetenarchiv.services.KontaktService;
import com.eigenbaumarkt.fetenarchiv.services.MediaService;
import com.eigenbaumarkt.fetenarchiv.services.MediaTypService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
@RequestMapping("/kontakte/{kontaktId}")
public class MediaController {

    private static final String VIEWS_MEDIA_CREATE_OR_UPDATE_FORM = "medien/mediaAnlegenOderUpdatenForm";
    private final MediaService mediaService;
    private final MediaTypService mediaTypService;
    private final KontaktService kontaktService;

    // @ModelAttribute stellt die angefragten Daten für jede Methode innerhalb der Klasse
    // unter der angegebenen Variable sicher:
    @ModelAttribute("typ")
    public Collection<MediaTyp> populateMediaTypes() {
        return this.mediaTypService.findAll();
    }

    @ModelAttribute("kontakt")
    public Kontakt findKontakt(@PathVariable("kontaktId") long kontaktId) {
        return kontaktService.findById(kontaktId);
    }

    @InitBinder("kontakt")
    public void initKontaktBinder(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    public MediaController(MediaService mediaService, MediaTypService mediaTypService, KontaktService kontaktService) {
        this.mediaService = mediaService;
        this.mediaTypService = mediaTypService;
        this.kontaktService = kontaktService;
    }

}
