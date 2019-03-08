package com.eigenbaumarkt.fetenarchiv.bootstrap;

import com.eigenbaumarkt.fetenarchiv.model.*;
import com.eigenbaumarkt.fetenarchiv.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataInitializer implements CommandLineRunner {

    private final OwnerService ownerService;
    private final AddressService addressService;
    private final PlaceService placeService;
    private final MediaService mediaService;
    private final MediaTypeService mediaTypeService;


    public DataInitializer(OwnerService ownerService, AddressService addressService,
                           PlaceService placeService, MediaService mediaService,
                           MediaTypeService mediaTypeService) {
        this.ownerService = ownerService;
        this.addressService = addressService;
        this.placeService = placeService;
        this.mediaService = mediaService;
        this.mediaTypeService = mediaTypeService;
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

        placeService.save(place1);

        address1.setPlace(place1);

        addressService.save(address1);

        owner1.setAddress(address1);

        owner1.setId(1L);

        ownerService.save(owner1);

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

        placeService.save(place2);

        address2.setPlace(place2);

        addressService.save(address2);

        owner2.setAddress(address2);
        owner2.setId(2L);

        ownerService.save(owner2);

        System.out.println("Zwei \'Owner\'-Objekte mit jeweils individuellen Adressen erstellt und geladen:");
        System.out.println(owner1.getFirstName() + " " + owner1.getLastName() + ", " + owner2.getFirstName() + " " + owner2.getLastName());


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

        mediaTypeService.save(mediaType1);

        media1.setMediaType(mediaType1);
        media1.setOwner(owner1);
        media1.setId(1L);

        mediaService.save(media1);

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

        mediaTypeService.save(mediaType2);

        media2.setMediaType(mediaType2);
        media2.setOwner(owner2);
        media2.setId(2L);

        mediaService.save(media2);

        System.out.println("Zwei \'Media\'-Objekte mit jeweils individuellem Typ erstellt und geladen!");


    }
}
