package com.eigenbaumarkt.fetenarchiv.bootstrap;

import com.eigenbaumarkt.fetenarchiv.model.*;
import com.eigenbaumarkt.fetenarchiv.services.MediaService;
import com.eigenbaumarkt.fetenarchiv.services.OwnerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataInitializer implements CommandLineRunner {

    private final OwnerService ownerService;
    private final MediaService mediaService;

    public DataInitializer(OwnerService ownerService, MediaService mediaService) {
        this.ownerService = ownerService;

        this.mediaService = mediaService;
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        LocalDate date = LocalDate.now();
        owner1.setCreationStamp(date);
        owner1.setLastUpdatedStamp(date);
        owner1.setFirstName("Manfred");
        owner1.setLastName("Krug");

        Address address1 = new Address();
        address1.setCreationStamp(date);
        address1.setLastUpdatedStamp(date);
        address1.setStreet("Wollinger Weg");
        address1.setNumber("23");
        address1.setId(1L);

        Place place1 = new Place();
        place1.setCreationStamp(date);
        place1.setLastUpdatedStamp(date);
        place1.setTitle("Oxfurthing");
        place1.setZipCode("83H-25");
        place1.setLand("Deutschland");
        place1.setRegion("Buvuria");
        place1.setId(1L);

        address1.setPlace(place1);

        owner1.setAddress(address1);

        owner1.setId(1L);

        Owner owner2 = new Owner();
        date = LocalDate.now();
        owner2.setCreationStamp(date);
        owner2.setLastUpdatedStamp(date);
        owner2.setFirstName("Ullrich");
        owner2.setLastName("Tramsfeld");

        Address address2 = new Address();
        address2.setCreationStamp(date);
        address2.setLastUpdatedStamp(date);
        address2.setStreet("Butzenbergstr.");
        address2.setNumber("5");
        address2.setId(2L);

        Place place2 = new Place();
        place2.setCreationStamp(date);
        place2.setLastUpdatedStamp(date);
        place2.setTitle("Munsfelden");
        place2.setZipCode("86774");
        place2.setLand("Deutschland");
        place2.setRegion("Bayern");
        place2.setId(2L);

        address2.setPlace(place2);

        owner2.setAddress(address2);
        owner2.setId(2L);

        System.out.println("Zwei \'Owner\'-Objekte mit jeweils individuellen Adressen erstellt und geladen!");


        Media media1 = new Media();
        date = LocalDate.now();
        media1.setCreationStamp(date);
        media1.setLastUpdatedStamp(date);
        media1.setDescription("Das erste Medien-Objekt");

        MediaType mediaType1 = new MediaType();
        mediaType1.setCreationStamp(date);
        mediaType1.setLastUpdatedStamp(date);
        mediaType1.setTitle("Bilddatei");
        mediaType1.setDescription("Bilddateien in verschiedenen Formaten");
        mediaType1.setId(1L);

        media1.setMediaType(mediaType1);
        media1.setOwner(owner1);
        media1.setId(1L);

        Media media2 = new Media();
        date = LocalDate.now();
        media2.setCreationStamp(date);
        media2.setLastUpdatedStamp(date);
        media2.setDescription("Das zweite Medien-Objekt");

        MediaType mediaType2 = new MediaType();
        mediaType2.setCreationStamp(date);
        mediaType2.setLastUpdatedStamp(date);
        mediaType2.setTitle("Filmdatei");
        mediaType2.setDescription("Filmdateien in verschiedenen Formaten");
        mediaType2.setId(2L);

        media2.setMediaType(mediaType2);
        media2.setOwner(owner2);
        media2.setId(2L);

        System.out.println("Zwei \'Media\'-Objekte mit jeweils individuellem Typ erstellt und geladen!");


    }
}
