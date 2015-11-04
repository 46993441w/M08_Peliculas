package com.example.david.peliculas.pelis;

import java.util.List;

/**
 * Created by david on 31/10/15.
 */
public class Results {
    private Boolean adult;
    private String backdrop_path;
    private List<Integer> genre_ids;
    private Integer id;
    private String original_language;
    private String original_title;
    private String overview;
    private String release_date;
    private String poster_path;
    private Double popularity;
    private String title;
    private Boolean video;
    private Double vote_average;
    private Integer vote_cont;

    /**
     *
     * @return si una pel·lícula per a adult o no
     */
    public Boolean getAdult() {
        return adult;
    }

    /**
     *
     * @param adult si una pel·lícula per a adult o no
     */
    public void setAdult(Boolean adult) {
        this.adult = adult;
    }

    /**
     *
     * @return path del fons
     */
    public String getBackdrop_path() {
        return backdrop_path;
    }

    /**
     *
     * @param backdrop_path path del fons
     */
    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    /**
     *
     * @return id del/s genere/s
     */
    public List<Integer> getGenre_ids() {
        return genre_ids;
    }

    /**
     *
     * @param genre_ids id del/s genere/s
     */
    public void setGenre_ids(List<Integer> genre_ids) {
        this.genre_ids = genre_ids;
    }

    /**
     *
     * @return id de la pel·lícula
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @param id id de la pel·lícula
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     * @return idioma original de la pel·lícula
     */
    public String getOriginal_language() {
        return original_language;
    }

    /**
     *
     * @param original_language idioma original de la pel·lícula
     */
    public void setOriginal_language(String original_language) {
        this.original_language = original_language;
    }

    /**
     *
     * @return titol original de la pel·lícula
     */
    public String getOriginal_title() {
        return original_title;
    }

    /**
     *
     * @param original_title titol original de la pel·lícula
     */
    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    /**
     *
     * @return overview
     */
    public String getOverview() {
        return overview;
    }

    /**
     *
     * @param overview overview
     */
    public void setOverview(String overview) {
        this.overview = overview;
    }

    /**
     *
     * @return data de la pel·lícula
     */
    public String getRelease_date() {
        return release_date;
    }

    /**
     *
     * @param release_date data de la pel·lícula
     */
    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    /**
     *
     * @return poster path
     */
    public String getPoster_path() {
        return poster_path;
    }

    /**
     *
     * @param poster_path poster path
     */
    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    /**
     *
     * @return popularitat
     */
    public Double getPopularity() {
        return popularity;
    }

    /**
     *
     * @param popularity popularitat
     */
    public void setPopularity(Double popularity) {
        this.popularity = popularity;
    }

    /**
     *
     * @return titol de la pel·lícula
     */
    public String getTitle() {
        return title;
    }

    /**
     *
     * @param title titol de la pel·lícula
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     *
     * @return la pel·lícula té vídeo
     */
    public Boolean getVideo() {
        return video;
    }

    /**
     *
     * @param video la pel·lícula té vídeo
     */
    public void setVideo(Boolean video) {
        this.video = video;
    }

    /**
     *
     * @return mitja de vots
     */
    public Double getVote_average() {
        return vote_average;
    }

    /**
     *
     * @param vote_average mitja de vots
     */
    public void setVote_average(Double vote_average) {
        this.vote_average = vote_average;
    }

    /**
     *
     * @return contador de vots
     */
    public Integer getVote_cont() {
        return vote_cont;
    }

    /**
     *
     * @param vote_cont contador de vots
     */
    public void setVote_cont(Integer vote_cont) {
        this.vote_cont = vote_cont;
    }
}
