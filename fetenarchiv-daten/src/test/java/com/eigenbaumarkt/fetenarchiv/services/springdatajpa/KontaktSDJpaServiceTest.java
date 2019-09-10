package com.eigenbaumarkt.fetenarchiv.services.springdatajpa;

import com.eigenbaumarkt.fetenarchiv.model.Kontakt;
import com.eigenbaumarkt.fetenarchiv.repositories.KontaktRepository;
import com.eigenbaumarkt.fetenarchiv.repositories.MediaRepository;
import com.eigenbaumarkt.fetenarchiv.repositories.MediaTypRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

// set up JUnit5 environment for Mockito
@ExtendWith(MockitoExtension.class)
class KontaktSDJpaServiceTest {

    public static final String LAST_NAME = "Gebsattel";

    @Mock
    KontaktRepository kontaktRepository;

    @Mock
    MediaRepository mediaRepository;

    @Mock
    MediaTypRepository mediaTypRepository;

    @InjectMocks
    KontaktSDJpaService service;

    Kontakt returnKontakt;

    // reset class variable 'returnKontakt' before each test method:
    @BeforeEach
    void setUp() {
        returnKontakt = Kontakt.builder().id(1L).lastName(LAST_NAME).build();
    }

    @Test
    void findByLastName() {
        when(kontaktRepository.findByLastName(any())).thenReturn(returnKontakt);

        Kontakt gebsattel = service.findByLastName(LAST_NAME);

        assertEquals(LAST_NAME, gebsattel.getLastName());

        verify(kontaktRepository).findByLastName(any());
    }

    @Test
    void findAll() {
        Set<Kontakt> returnKontakteSet = new HashSet<>();
        returnKontakteSet.add(Kontakt.builder().id(1L).build());
        returnKontakteSet.add(Kontakt.builder().id(2L).build());

        when(kontaktRepository.findAll()).thenReturn(returnKontakteSet);

        Set<Kontakt> kontakte = service.findAll();

        assertNotNull(kontakte);
        assertEquals(2,kontakte.size());
    }

    // test 'findById':
    @Test
    void findById() {
        when(kontaktRepository.findById(anyLong())).thenReturn(Optional.of(returnKontakt));

        Kontakt kontakt = service.findById(1L);

        assertNotNull(kontakt);
    }

    // test '.orElse':
    @Test
    void findByIdNotFound() {
        when(kontaktRepository.findById(anyLong())).thenReturn(Optional.empty());

        Kontakt kontakt = service.findById(1L);

        assertNull(kontakt);
    }

    @Test
    void save() {
        Kontakt kontaktToSave = Kontakt.builder().id(1L).build();

        when(kontaktRepository.save(any())).thenReturn(returnKontakt);

        Kontakt savedKontakt = service.save(kontaktToSave);

        assertNotNull(savedKontakt);

        verify(kontaktRepository).save(any());
    }

    @Test
    void delete() {
        service.delete(returnKontakt);

        // test methods that do not return a value with verify:
        // verify if the method was called once
        verify(kontaktRepository, times(1)).delete(any());
    }

    @Test
    void deleteById() {
        service.deleteById(1L);

        // concise syntax where the verify-option assumes by default one interaction
        verify(kontaktRepository).deleteById(anyLong());
    }
}
