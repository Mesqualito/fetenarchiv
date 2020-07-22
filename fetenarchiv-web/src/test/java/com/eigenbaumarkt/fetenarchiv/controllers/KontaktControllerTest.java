package com.eigenbaumarkt.fetenarchiv.controllers;

import com.eigenbaumarkt.fetenarchiv.model.Kontakt;
import com.eigenbaumarkt.fetenarchiv.services.KontaktService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class KontaktControllerTest {

    Set<Kontakt> kontakte;

    // set up Controller for testing
    MockMvc mockMvc;

    @Mock
    KontaktService kontaktService;

    @InjectMocks
    KontaktController controller;

    // for each test method this initializes up a mock environment for the controller
    @BeforeEach
    void setUp() {
        kontakte = new HashSet<>();
        kontakte.add(Kontakt.builder().id(1L).build());
        kontakte.add(Kontakt.builder().id(2L).build());

        mockMvc = MockMvcBuilders
                .standaloneSetup(controller)
                .build();
    }

    @Test
    void findKontakte() throws Exception {

        mockMvc.perform(get("/kontakte/find"))
                .andExpect(status().isOk())
                .andExpect(view().name("kontakte/findKontakte"))
                .andExpect(model().attributeExists("kontakt"));

        verifyZeroInteractions(kontaktService);
    }

    @Test
    void processFindFormReturnMany() throws Exception {
        when(kontaktService.findAllByLastNameLike(anyString())).thenReturn(Arrays.asList(Kontakt.builder().id(1L).build(),
                Kontakt.builder().id(2L).build()));

        mockMvc.perform(get("/kontakte"))
                .andExpect(status().isOk())
                .andExpect(view().name("kontakte/kontaktListe"))
                .andExpect(model().attribute("auswahl", hasSize(2)));
    }

    @Test
    void processFindFormReturnOne() throws Exception {
        when(kontaktService.findAllByLastNameLike(anyString())).thenReturn(Arrays.asList(Kontakt.builder().id(1L).build()));

        mockMvc.perform(get("/kontakte"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/kontakte/1"))
                // .andExpect(model().attribute("kontakte", hasProperty("id", is(1L))))
                ;
    }

    @Test
    void displayKontakt() throws Exception {
        when(kontaktService.findById(anyLong())).thenReturn(Kontakt.builder().id(1L).build());

        mockMvc.perform(get("/kontakte/123"))
                .andExpect(status().isOk())
                .andExpect(view().name("kontakte/kontaktDetails"))
                .andExpect(model().attribute("kontakt", hasProperty("id", is(1L))));
    }

    @Test
    void initCreationForm() throws Exception {
        mockMvc.perform(get("/kontakte/neu"))
                .andExpect(status().isOk())
                .andExpect(view().name("kontakte/kontaktAnlegenOderUpdatenForm"))
                .andExpect(model().attributeExists("kontakt"));

        verifyZeroInteractions(kontaktService);
    }

    @Test
    void processCreationForm() throws Exception {
        when(kontaktService.save(ArgumentMatchers.any())).thenReturn(Kontakt.builder().id(1L).build());

        mockMvc.perform(post("/kontakte/neu"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/kontakte/1"))
                .andExpect(model().attributeExists("kontakt"));

        verify(kontaktService).save(ArgumentMatchers.any());
    }

    @Test
    void initUpdateKontaktForm() throws Exception {
        when(kontaktService.findById(anyLong())).thenReturn(Kontakt.builder().id(1L).build());

        mockMvc.perform(get("/kontakte/1/aendern"))
                .andExpect(status().isOk())
                .andExpect(view().name("kontakte/kontaktAnlegenOderUpdatenForm"))
                .andExpect(model().attributeExists("kontakt"));

        verifyZeroInteractions(kontaktService);
    }

    @Test
    void processUpdateKontaktForm() throws Exception {
        when(kontaktService.save(ArgumentMatchers.any())).thenReturn(Kontakt.builder().id(1L).build());

        mockMvc.perform(post("/kontakte/1/aendern"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/kontakte/1"))
                .andExpect(model().attributeExists("kontakt"));

        verify(kontaktService).save(ArgumentMatchers.any());
    }
}
