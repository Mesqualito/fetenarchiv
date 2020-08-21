package com.eigenbaumarkt.fetenarchiv.controllers;

import com.eigenbaumarkt.fetenarchiv.model.Kontakt;
import com.eigenbaumarkt.fetenarchiv.model.Media;
import com.eigenbaumarkt.fetenarchiv.model.MediaTyp;
import com.eigenbaumarkt.fetenarchiv.services.KontaktService;
import com.eigenbaumarkt.fetenarchiv.services.MediaService;
import com.eigenbaumarkt.fetenarchiv.services.MediaTypService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

@Controller
@RequestMapping("/kontakte/{kontaktId}")
public class MediaController {

    private static final String VIEWS_MEDIEN_CREATE_OR_UPDATE_FORM = "medien/mediaAnlegenOderUpdatenForm";
    private final MediaService mediaService;
    private final MediaTypService mediaTypService;
    private final KontaktService kontaktService;

    // @ModelAttribute stellt die angefragten Daten für jede Methode innerhalb der Klasse
    // unter der angegebenen Variable sicher:
    @ModelAttribute("mediaTypen")
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

    @GetMapping("/media/neu")
    public String initCreationForm(Kontakt kontakt, Model model) {
        Media media = new Media();
        kontakt.getMediaSet().add(media);
        model.addAttribute("media", media);
        return VIEWS_MEDIEN_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("/media/neu")
    public String processCreationForm(Kontakt kontakt, @Valid Media media, BindingResult result, ModelMap model) {
        if (StringUtils.hasLength(media.getTitel()) && media.isNew() && kontakt.getMedia(media.getTitel(), true) != null){
            result.rejectValue("titel", "Duplikat", "existiert bereits");
        }
        kontakt.getMediaSet().add(media);
        if (result.hasErrors()) {
            model.put("media", media);
            return VIEWS_MEDIEN_CREATE_OR_UPDATE_FORM;
        } else {
            mediaService.save(media);
            return "redirect:/kontakte/" + kontakt.getId();
        }
    }

    @GetMapping("/medien/{mediaId}/aendern")
    public String initUpdateForm(@PathVariable Long mediaId, Model model) {
        model.addAttribute("media", mediaService.findById(mediaId));
        return VIEWS_MEDIEN_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("/medien/{mediaId}/aendern")
    public String processUpdateForm(@Valid Media media, BindingResult result, Kontakt kontakt, Model model) {
        if (result.hasErrors()) {
            media.setKontakt(kontakt);
            model.addAttribute("media", media);
            return VIEWS_MEDIEN_CREATE_OR_UPDATE_FORM;
        } else {
            kontakt.getMediaSet().add(media);
            mediaService.save(media);
            return "redirect:/kontakte/" + kontakt.getId();
        }
    }
}
