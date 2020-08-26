package com.eigenbaumarkt.fetenarchiv.controllers;

import com.eigenbaumarkt.fetenarchiv.model.Kontakt;
import com.eigenbaumarkt.fetenarchiv.model.Media;
import com.eigenbaumarkt.fetenarchiv.model.MediaTyp;
import com.eigenbaumarkt.fetenarchiv.services.KontaktService;
import com.eigenbaumarkt.fetenarchiv.services.MediaService;
import com.eigenbaumarkt.fetenarchiv.services.MediaTypService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashSet;
import java.util.Set;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
public class MediaControllerTest {

    @Mock
    MediaService mediaService;

    @Mock
    KontaktService kontaktService;

    @Mock
    MediaTypService mediaTypService;

    @InjectMocks
    MediaController mediaController;

    MockMvc mockMvc;

    Kontakt kontakt;
    Set<MediaTyp> mediaTypSet;

    @BeforeEach
    void setUp() {
        kontakt = Kontakt.builder().id(1L).build();

        mediaTypSet = new HashSet<>();
        mediaTypSet.add(MediaTyp.builder().id(1L).titel("Filmdatei").build());
        mediaTypSet.add(MediaTyp.builder().id(2L).titel("Bilddatei").build());

        mockMvc = MockMvcBuilders
                .standaloneSetup(mediaController)
                .build();
    }

    @Test
    void initCreationForm() throws Exception {
        when(kontaktService.findById(anyLong())).thenReturn(kontakt);
        when(mediaTypService.findAll()).thenReturn(mediaTypSet);

        mockMvc.perform(get("/kontakte/1/medien/neu"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("kontakt"))
                .andExpect(model().attributeExists("media"))
                .andExpect(view().name("medien/mediaAnlegenOderAendernForm"));
    }

    @Test
    void processCreationForm() throws Exception {
        when(kontaktService.findById(anyLong())).thenReturn(kontakt);
        when(mediaTypService.findAll()).thenReturn(mediaTypSet);

        mockMvc.perform(post("/kontakte/1/medien/neu"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/kontakte/1"));

        verify(mediaService).save(any());
    }

    @Test
    void initUpdateForm() throws Exception {
        when(kontaktService.findById(anyLong())).thenReturn(kontakt);
        when(mediaTypService.findAll()).thenReturn(mediaTypSet);
        when(mediaService.findById(anyLong())).thenReturn(Media.builder().id(2L).build());

        mockMvc.perform(get("/kontakte/1/medien/2/aendern"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("kontakt"))
                .andExpect(model().attributeExists("media"))
                .andExpect(view().name("medien/mediaAnlegenOderAendernForm"));
    }

    @Test
    void processUpdateForm() throws Exception {
        when(kontaktService.findById(anyLong())).thenReturn(kontakt);
        when(mediaTypService.findAll()).thenReturn(mediaTypSet);

        mockMvc.perform(post("/kontakte/1/medien/2/aendern"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/kontakte/1"));

        verify(mediaService).save(any());
    }

    @Test
    void populatePetTypes() {
        //todo impl
    }

    @Test
    void findOwner() {
        //todo impl
    }

    @Test
    void initOwnerBinder() {
        //todo impl
    }

}
