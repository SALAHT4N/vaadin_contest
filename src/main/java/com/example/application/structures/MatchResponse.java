package com.example.application.structures;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public class MatchResponse {

    public void setStatus(String status) {
        this.status = status;
    }

    private String status;

    private List<Match> data;

    public List<Match> getData() {
        return data;
    }

    public void setData(List<Match> data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }
}
