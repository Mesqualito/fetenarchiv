package com.eigenbaumarkt.fetenarchiv.formatters;

import com.eigenbaumarkt.fetenarchiv.model.MediaTyp;
import com.eigenbaumarkt.fetenarchiv.services.MediaTypService;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Collection;
import java.util.Locale;

// Spring benötigt den Formatter für Thymeleaf's '<input th:replace="~{fragments/selectField :: select ('Typ', 'mediaTyp', ${mediaTypen})}" />
// see: https://docs.spring.io/spring-framework/docs/current/spring-framework-reference/core.html#format

@Component
public class MediaTypFormatter implements Formatter<MediaTyp> {

    private final MediaTypService mediaTypService;

    public MediaTypFormatter(MediaTypService mediaTypService) {
        this.mediaTypService = mediaTypService;
    }

    @Override
    public String print(MediaTyp mediaTyp, Locale locale) {
        return mediaTyp.getTitel();
    }

    @Override
    public MediaTyp parse(String text, Locale locale) throws ParseException {
        Collection<MediaTyp> findMediaTypen = mediaTypService.findAll();

        for (MediaTyp mediaTyp : findMediaTypen) {
            if (mediaTyp.getTitel().equals(text)) {
                return mediaTyp;
            }
        }

        throw new ParseException("MediaTyp nicht gefunden: " + text, 0);
    }
}
