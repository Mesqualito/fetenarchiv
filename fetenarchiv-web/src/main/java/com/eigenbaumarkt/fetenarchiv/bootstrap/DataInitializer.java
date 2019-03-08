package com.eigenbaumarkt.fetenarchiv.bootstrap;

import com.eigenbaumarkt.fetenarchiv.services.MediaService;
import com.eigenbaumarkt.fetenarchiv.services.OwnerService;
import com.eigenbaumarkt.fetenarchiv.services.map.MediaServiceMap;
import com.eigenbaumarkt.fetenarchiv.services.map.OwnerServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

// Spring-spezifische Lösung: 'DataInitializer' als Spring-Bean,
// 'CommandLineRunner'-Implementation zur automatischen Ausführung
// direkt nach dem erfolgreichem Start der Applikation
@Component
public class DataInitializer implements CommandLineRunner {

    private final OwnerService ownerService;
    private final MediaService mediaService;

    public DataInitializer() {

        ownerService = new OwnerServiceMap();
        mediaService = new MediaServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
