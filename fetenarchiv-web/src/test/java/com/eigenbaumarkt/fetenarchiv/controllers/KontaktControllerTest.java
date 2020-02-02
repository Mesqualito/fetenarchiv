package com.eigenbaumarkt.fetenarchiv.controllers;

import com.eigenbaumarkt.fetenarchiv.model.Kontakt;
import com.eigenbaumarkt.fetenarchiv.services.KontaktService;
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

import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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
    void listKontakte() throws Exception {
        when(kontaktService.findAll()).thenReturn(kontakte);

        mockMvc.perform(get("/kontakte"))
                .andExpect(status().isOk())
        .andExpect(view().name("kontakte/index"))
        .andExpect(model().attribute("kontakte", hasSize(2)));
    }

    @Test
    void listKontakteByIndex() throws Exception {
        when(kontaktService.findAll()).thenReturn(kontakte);

        mockMvc.perform(get("/kontakte"))
                .andExpect(status().isOk())
                .andExpect(view().name("kontakte/index"))
                .andExpect(model().attribute("kontakte", hasSize(2)));
    }

    @Test
    void findKontakte() throws Exception {

        mockMvc.perform(get("/kontakte/find"))
                .andExpect(status().isOk())
                .andExpect(view().name("kontakte/findKontakte"));

        // no interaction with Service, because still not implemented ;-)
        verifyZeroInteractions(kontaktService);
    }

    @Test
    void displayKontakt() throws Exception {
        when(kontaktService.findById(anyLong())).thenReturn(Kontakt.builder().id(1L).build());

        mockMvc.perform(get("/kontakte/123"))
                .andExpect(status().isOk())
                .andExpect(view().name("kontakte/kontaktDetails"))
                .andExpect(model().attribute("kontakt", hasProperty("id", is(1L))));
    }

}
