package com.reluck.java_marvelapi;

public class Film {

    private String title;
    private Integer episodeId;

    public Film(String title, Integer episodeId) {
        this.title = title;
        this.episodeId = episodeId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getEpisodeId() {
        return episodeId;
    }

    public void setEpisodeId(Integer episodeId) {
        this.episodeId = episodeId;
    }
}
