package com.reluck.java_marvelapi;

import com.google.gson.annotations.SerializedName;

public class Film {

    private String title;

    @SerializedName("release_date")
    private String releaseDate;

    @SerializedName("opening_crawl")
    private String openingCrawl;

    private Integer episodeId;

    private String url;


    public Film() {
    }

    public Film(String title, String releaseDate, String openingCrawl, Integer episodeId) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.openingCrawl = openingCrawl;
        this.episodeId = episodeId;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getOpeningCrawl() {
        return openingCrawl;
    }

    public void setOpeningCrawl(String openingCrawl) {
        this.openingCrawl = openingCrawl;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
