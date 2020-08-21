package com.eigenbaumarkt.fetenarchiv.bootstrap;

import com.eigenbaumarkt.fetenarchiv.model.*;
import com.eigenbaumarkt.fetenarchiv.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.LocalDate;

@Component
public class DataInitializer implements CommandLineRunner {

    private final KontaktService kontaktService;
    private final AdresseService adresseService;
    private final OrtService ortService;
    private final MediaService mediaService;
    private final MediaTypService mediaTypService;
    private final TerminService terminService;


    public DataInitializer(KontaktService kontaktService, AdresseService adresseService,
                           OrtService ortService, MediaService mediaService,
                           MediaTypService mediaTypService, TerminService terminService) {
        this.kontaktService = kontaktService;
        this.adresseService = adresseService;
        this.ortService = ortService;
        this.mediaService = mediaService;
        this.mediaTypService = mediaTypService;
        this.terminService = terminService;
    }

    @Override
    public void run(String... args) throws Exception {

        // if there is already data persisted, don't repeat
        int count = mediaTypService.findAll().size();

        if(count == 0) {
            loadData();
        }

    }

    private void loadData() {
        Kontakt kontakt1 = new Kontakt();
        kontakt1.setFirstName("Manfred");
        kontakt1.setLastName("Krug");

        Adresse adresse1 = new Adresse();
        adresse1.setStrasse("Wollinger Weg");
        adresse1.setHausNr("23");

        Ort ort1 = new Ort();
        ort1.setTitel("Oxfurthing");
        ort1.setPlz("83H-25");
        ort1.setLand("Deutschland");
        ort1.setRegion("Buvuria");

        Ort savedOrt1 = ortService.save(ort1);

        adresse1.setOrt(savedOrt1);

        Adresse savedAdresse1 = adresseService.save(adresse1);

        kontakt1.setAdresse(savedAdresse1);

        kontaktService.save(kontakt1);

        Kontakt kontakt2 = new Kontakt();
        kontakt2.setFirstName("Ullrich");
        kontakt2.setLastName("Tramsfeld");

        Adresse adresse2 = new Adresse();
        adresse2.setStrasse("Butzenbergstr.");
        adresse2.setHausNr("5");

        Ort ort2 = new Ort();
        ort2.setTitel("Munsfelden");
        ort2.setPlz("86774");
        ort2.setLand("Deutschland");
        ort2.setRegion("Bayern");

        ortService.save(ort2);

        adresse2.setOrt(ort2);

        adresseService.save(adresse2);

        kontakt2.setAdresse(adresse2);

        kontaktService.save(kontakt2);

        System.out.println("Zwei \'Kontakt\'-Objekte mit jeweils individuellen Adressen erstellt und geladen:");
        System.out.println(kontakt1.getFirstName() + " " + kontakt1.getLastName() + ", " + kontakt2.getFirstName() + " " + kontakt2.getLastName());

        Media media1 = new Media();
        media1.setTitel("grossvogl.jpg");
        media1.setBeschreibung("Das erste Medien-Objekt");

        MediaTyp mediaTyp1 = new MediaTyp();
        mediaTyp1.setTitel("Bilddatei");
        mediaTyp1.setBeschreibung("Bilddateien in verschiedenen Formaten");

        mediaTypService.save(mediaTyp1);

        media1.setMediaTyp(mediaTyp1);
        media1.setKontakt(kontakt1);

        Media savedMedia1 = mediaService.save(media1);

        Media media2 = new Media();
        media2.setTitel("Kleine_Hunde_beißen.avi");
        media2.setBeschreibung("Das zweite Medien-Objekt");

        MediaTyp mediaTyp2 = new MediaTyp();
        mediaTyp2.setTitel("Filmdatei");
        mediaTyp2.setBeschreibung("Filmdateien in verschiedenen Formaten");

       mediaTypService.save(mediaTyp2);

        media2.setMediaTyp(mediaTyp2);
        media2.setKontakt(kontakt2);

        Media savedMedia2 = mediaService.save(media2);

        System.out.println("Zwei \'Media\'-Objekte mit jeweils individuellem Typ erstellt und geladen!");

        kontakt1.getMediaSet().add(savedMedia1);
        kontakt2.getMediaSet().add(savedMedia2);

        System.out.println("Jeweils ein Media-Objekt zu einem Kontakt gesichert.");

        Termin ersterTermin = new Termin();
        ersterTermin.setKontakt(kontakt1);
        ersterTermin.setDatum(LocalDate.now());
        ersterTermin.setTitel("Der erste Termin!");
        terminService.save(ersterTermin);

        System.out.println("Ein erster Termin zu einem Kontakt gesichert.");
    }
}
