package com.eigenbaumarkt.fetenarchiv.controllers;


import com.eigenbaumarkt.fetenarchiv.model.Kontakt;
import com.eigenbaumarkt.fetenarchiv.model.Media;
import com.eigenbaumarkt.fetenarchiv.model.MediaTyp;
import com.eigenbaumarkt.fetenarchiv.services.MediaService;
import com.eigenbaumarkt.fetenarchiv.services.TerminService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.util.UriTemplate;

import java.net.URI;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class TerminControllerTest {

    private static final String TERMIN_ANLEGEN_ODER_AENDERN_FORM = "medien/terminAnlegenOderAendernForm";

    @Mock
    MediaService mediaService;

    @Mock
    TerminService terminService;

    @InjectMocks
    TerminController terminController;

    private MockMvc mockMvc;

    private final UriTemplate termineUriTemplate = new UriTemplate("/kontakte/{kontaktId}/medien/{mediaId}/termine/neu");
    private final Map<String, String> uriVariables = new HashMap<>();
    private URI termineUri;

    @BeforeEach
    void setUp() {
        Long mediaId = 1L;
        Long kontaktId = 1L;
        when(mediaService.findById(anyLong()))
                .thenReturn(
                        Media.builder()
                                .id(mediaId)
                                .titel("Cutie")
                                .terminSet(new HashSet<>())
                                .kontakt(Kontakt.builder()
                                        .id(kontaktId)
                                        .lastName("Doe")
                                        .firstName("Joe")
                                        .build())
                                .mediaTyp(MediaTyp.builder()
                                        .titel("PDF-Datei").build())
                                .build()
                );

        uriVariables.clear();
        uriVariables.put("kontaktId", kontaktId.toString());
        uriVariables.put("mediaId", mediaId.toString());
        termineUri = termineUriTemplate.expand(uriVariables);

        mockMvc = MockMvcBuilders
                .standaloneSetup(terminController)
                .build();
    }

    @Test
    void initNewTerminForm() throws Exception {
        mockMvc.perform(get(termineUri))
                .andExpect(status().isOk())
                .andExpect(view().name(TERMIN_ANLEGEN_ODER_AENDERN_FORM))
        ;
    }


    @Test
    void processNewTerminForm() throws Exception {
        mockMvc.perform(post(termineUri)
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("date", "2018-11-11")
                .param("description", "ein weiterer Besuch"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/kontakte/{kontaktId}"))
                .andExpect(model().attributeExists("termin"))
        ;
    }
}
