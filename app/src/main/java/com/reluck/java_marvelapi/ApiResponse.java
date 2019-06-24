package com.reluck.java_marvelapi;

import java.util.List;

public class ApiResponse {

    private Integer count;
    private List<Film> results;

    public ApiResponse(Integer count, List<Film> results) {
        this.count = count;
        this.results = results;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<Film> getResults() {
        return results;
    }

    public void setResults(List<Film> results) {
        this.results = results;
    }
}
