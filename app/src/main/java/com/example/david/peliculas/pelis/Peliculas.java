package com.example.david.peliculas.pelis;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe Peliculas
 */
public class Peliculas implements Serializable{
    private Integer page;
    private java.util.List<Results> results = new ArrayList<>();
    private Integer total_pages;
    private Integer total_results;

    /**
     *
     * @return El nombre total de resultats
     */
    public Integer getTotal_results() {
        return total_results;
    }

    /**
     *
     * @param total_results Els resultats totals
     */
    public void setTotal_results(Integer total_results) {
        this.total_results = total_results;
    }

    /**
     *
     * @return la pàgina
     */
    public Integer getPage() {
        return page;
    }

    /**
     *
     * @param page la pàgina
     */
    public void setPage(Integer page) {
        this.page = page;
    }

    /**
     *
     * @return una llista amb totes les pel·lícules
     */
    public List<Results> getResults() {
        return results;
    }

    /**
     *
     * @param results una llista amb totes les pel·lícules
     */
    public void setResults(List<Results> results) {
        this.results = results;
    }

    /**
     *
     * @return El total de pàgines
     */
    public Integer getTotal_pages() {
        return total_pages;
    }

    /**
     *
     * @param total_pages El total de pàgines
     */
    public void setTotal_pages(Integer total_pages) {
        this.total_pages = total_pages;
    }
}
