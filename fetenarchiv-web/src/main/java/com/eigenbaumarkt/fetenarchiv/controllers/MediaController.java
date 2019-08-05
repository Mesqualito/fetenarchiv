package com.eigenbaumarkt.fetenarchiv.controllers;

import com.eigenbaumarkt.fetenarchiv.services.MediaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MediaController {

    private final MediaService mediaService;

    public MediaController(MediaService mediaService) {
        this.mediaService = mediaService;
    }

    @RequestMapping({"/media", "/media.html", "/media/index", "/media/index.htm", "/media/index.html"})
    public String listMedia(Model model){

        model.addAttribute("media", mediaService.findAll());

        return "media/index";
    }

}
