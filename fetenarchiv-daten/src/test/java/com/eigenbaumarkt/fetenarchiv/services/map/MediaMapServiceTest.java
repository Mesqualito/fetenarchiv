package com.eigenbaumarkt.fetenarchiv.services.map;

import com.eigenbaumarkt.fetenarchiv.model.Media;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class MediaMapServiceTest {

    private MediaMapService mediaMapService;
    private final Long mediaId = 1L;

    @BeforeEach
    void setUp() {
        mediaMapService = new MediaMapService();
        mediaMapService.save(Media.builder().id(mediaId).build());
    }

    @Test
    void findAll() {

        Set<Media> mediaSet = mediaMapService.findAll();
        assertEquals(1, mediaSet.size());
    }

    @Test
    void findByIdExistingId() {

        Media media = mediaMapService.findById(mediaId);
        assertEquals(mediaId, media.getId());

    }

    @Test
    void findByIdNotExistingId() {

        Media media = mediaMapService.findById(5L);

        assertNull(media);

    }

    @Test
    void saveExistingId() {

        Long id = 2L;

        Media media2 = Media.builder().id(id).build();
        Media savedMedia = mediaMapService.save(media2);

        assertEquals(id, savedMedia.getId());
    }

    @Test
    void saveDuplicatedId() {

        Long id = 1L;
        Media media2 = Media.builder().id(id).build();
        Media savedMedia = mediaMapService.save(media2);

        assertEquals(id, savedMedia.getId());
        assertEquals(1, mediaMapService.findAll().size());
    }

    @Test
    void saveNoId() {

        Media savedMedia = mediaMapService.save(Media.builder().build());

        assertNotNull(savedMedia);
        assertNotNull(savedMedia.getId());
        assertEquals(2, mediaMapService.findAll().size());
    }

    @Test
    void deleteMedia() {

        mediaMapService.delete(mediaMapService.findById(mediaId));

        assertEquals(0, mediaMapService.findAll().size());
    }

    @Test
    void deleteWithWrongId() {

        Media media = Media.builder().id(5L).build();
        mediaMapService.delete(media);

        assertEquals(1, mediaMapService.findAll().size());
    }

    @Test
    void deleteWithNullId() {

        Media media = Media.builder().build();

        mediaMapService.delete(media);

        assertEquals(1, mediaMapService.findAll().size());
    }

    @Test
    void deleteNull() {

        mediaMapService.delete(null);

        assertEquals(1, mediaMapService.findAll().size());
    }

    @Test
    void deleteByIdCorrectId() {

        mediaMapService.deleteById(mediaId);

        assertEquals(0, mediaMapService.findAll().size());
    }

    @Test
    void deleteByIdWrongId() {

        mediaMapService.deleteById(5L);

        assertEquals(1, mediaMapService.findAll().size());

    }

    @Test
    void deleteByIdNullId() {

        mediaMapService.deleteById(null);

        assertEquals(1, mediaMapService.findAll().size());
    }
}
