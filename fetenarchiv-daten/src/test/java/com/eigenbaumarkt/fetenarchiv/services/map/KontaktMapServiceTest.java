package com.eigenbaumarkt.fetenarchiv.services.map;

import com.eigenbaumarkt.fetenarchiv.model.Kontakt;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class KontaktMapServiceTest {

    KontaktMapService kontaktMapService;

    final Long kontaktId = 1L;
    final String lastName = "Gebsattel";


    // will run before each test-method
    @BeforeEach
    void setUp() {

        // Initialisierung eines KontaktMapService-Objekts und Speichern eines Kontaktes darin
        // Spring dependency injection - Nachbildung:
        kontaktMapService = new KontaktMapService(new MediaTypMapService(), new MediaMapService());
        kontaktMapService.save(Kontakt.builder().id(kontaktId).lastName(lastName).build());
    }

    @Test
    void findAll() {
        Set<Kontakt> kontaktSet = kontaktMapService.findAll();

        assertEquals(1, kontaktSet.size());
    }

    @Test
    void findById() {
        Kontakt kontakt = kontaktMapService.findById(kontaktId);

        assertEquals(kontaktId, kontakt.getId());
    }

    @Test
    void saveExistingId() {
        Long id = 2L;

        Kontakt kontakt2 = Kontakt.builder().id(id).build();
        Kontakt savedKontakt = kontaktMapService.save(kontakt2);

        assertEquals(id, savedKontakt.getId());
    }

    @Test
    void saveNoId() {
        Kontakt savedKontakt = kontaktMapService.save(Kontakt.builder().build());

        assertNotNull(savedKontakt);
        assertNotNull(savedKontakt.getId());
    }

    @Test
    void delete() {
        // deleting by object
        kontaktMapService.delete(kontaktMapService.findById(kontaktId));

        assertEquals(0, kontaktMapService.findAll().size());
    }

    @Test
    void deleteById() {
        // deleting by id
        kontaktMapService.deleteById(kontaktId);

        assertEquals(0, kontaktMapService.findAll().size());
    }

    @Test
    void findByLastName() {
        Kontakt gebsattel = kontaktMapService.findByLastName(lastName);

        assertNotNull(gebsattel);
        assertEquals(kontaktId, gebsattel.getId());
    }

    @Test
    void findByLastNameNotFound() {
        Kontakt gebsattel = kontaktMapService.findByLastName("Nonsens");

        assertNull(gebsattel);
    }
}