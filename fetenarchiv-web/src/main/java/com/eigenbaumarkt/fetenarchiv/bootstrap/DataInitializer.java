package com.eigenbaumarkt.fetenarchiv.bootstrap;

import com.eigenbaumarkt.fetenarchiv.model.*;
import com.eigenbaumarkt.fetenarchiv.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataInitializer implements CommandLineRunner {

    private final KontaktService kontaktService;
    private final AdressenService adressenService;
    private final OrtService ortService;
    private final MediaService mediaService;
    private final MediaTypenService mediaTypenService;


    public DataInitializer(KontaktService kontaktService, AdressenService adressenService,
                           OrtService ortService, MediaService mediaService,
                           MediaTypenService mediaTypenService) {
        this.kontaktService = kontaktService;
        this.adressenService = adressenService;
        this.ortService = ortService;
        this.mediaService = mediaService;
        this.mediaTypenService = mediaTypenService;
    }

    @Override
    public void run(String... args) throws Exception {

        Kontakt kontakt1 = new Kontakt();
        LocalDate date = LocalDate.now();
        kontakt1.setCreationStamp(date);
        kontakt1.setLastUpdatedStamp(date);
        kontakt1.setFirstName("Manfred");
        kontakt1.setLastName("Krug");

        Adresse adresse1 = new Adresse();
        adresse1.setCreationStamp(date);
        adresse1.setLastUpdatedStamp(date);
        adresse1.setStreet("Wollinger Weg");
        adresse1.setNumber("23");

        Ort ort1 = new Ort();
        ort1.setCreationStamp(date);
        ort1.setLastUpdatedStamp(date);
        ort1.setTitle("Oxfurthing");
        ort1.setZipCode("83H-25");
        ort1.setLand("Deutschland");
        ort1.setRegion("Buvuria");

        ortService.save(ort1);

        adresse1.setOrt(ort1);

        adressenService.save(adresse1);

        kontakt1.setAdresse(adresse1);

        kontaktService.save(kontakt1);

        Kontakt kontakt2 = new Kontakt();
        date = LocalDate.now();
        kontakt2.setCreationStamp(date);
        kontakt2.setLastUpdatedStamp(date);
        kontakt2.setFirstName("Ullrich");
        kontakt2.setLastName("Tramsfeld");

        Adresse adresse2 = new Adresse();
        adresse2.setCreationStamp(date);
        adresse2.setLastUpdatedStamp(date);
        adresse2.setStreet("Butzenbergstr.");
        adresse2.setNumber("5");

        Ort ort2 = new Ort();
        ort2.setCreationStamp(date);
        ort2.setLastUpdatedStamp(date);
        ort2.setTitle("Munsfelden");
        ort2.setZipCode("86774");
        ort2.setLand("Deutschland");
        ort2.setRegion("Bayern");

        ortService.save(ort2);

        adresse2.setOrt(ort2);

        adressenService.save(adresse2);

        kontakt2.setAdresse(adresse2);

        kontaktService.save(kontakt2);

        System.out.println("Zwei \'Kontakt\'-Objekte mit jeweils individuellen Adressen erstellt und geladen:");
        System.out.println(kontakt1.getFirstName() + " " + kontakt1.getLastName() + ", " + kontakt2.getFirstName() + " " + kontakt2.getLastName());


        Media media1 = new Media();
        date = LocalDate.now();
        media1.setCreationStamp(date);
        media1.setLastUpdatedStamp(date);
        media1.setDescription("Das erste Medien-Objekt");

        MediaTyp mediaTyp1 = new MediaTyp();
        mediaTyp1.setCreationStamp(date);
        mediaTyp1.setLastUpdatedStamp(date);
        mediaTyp1.setTitle("Bilddatei");
        mediaTyp1.setDescription("Bilddateien in verschiedenen Formaten");

        mediaTypenService.save(mediaTyp1);

        media1.setMediaTyp(mediaTyp1);
        media1.setKontakt(kontakt1);

        mediaService.save(media1);

        Media media2 = new Media();
        date = LocalDate.now();
        media2.setCreationStamp(date);
        media2.setLastUpdatedStamp(date);
        media2.setDescription("Das zweite Medien-Objekt");

        MediaTyp mediaTyp2 = new MediaTyp();
        mediaTyp2.setCreationStamp(date);
        mediaTyp2.setLastUpdatedStamp(date);
        mediaTyp2.setTitle("Filmdatei");
        mediaTyp2.setDescription("Filmdateien in verschiedenen Formaten");

        mediaTypenService.save(mediaTyp2);

        media2.setMediaTyp(mediaTyp2);
        media2.setKontakt(kontakt2);

        mediaService.save(media2);

        System.out.println("Zwei \'Media\'-Objekte mit jeweils individuellem Typ erstellt und geladen!");

    }
}
