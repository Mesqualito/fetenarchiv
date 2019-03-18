package com.eigenbaumarkt.fetenarchiv.model;

import java.time.LocalDate;

public class Termin extends Basis {

    private LocalDate date;
    private String title;
    private Media media;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Media getMedia() {
        return media;
    }

    public void setMedia(Media media) {
        this.media = media;
    }
}
