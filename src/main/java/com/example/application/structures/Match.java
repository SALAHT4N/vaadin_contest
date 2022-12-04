package com.example.application.structures;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDateTime;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Match {


    private String away_team_en;
    private String home_team_en;
    private String home_flag;
    private String away_flag;
    private String away_score;
    private String home_score;
    private String local_date;
    public String getAway_team_en() {
        return away_team_en;
    }

    public void setAway_team_en(String away_team_en) {
        this.away_team_en = away_team_en;
    }

    public String getHome_team_en() {
        return home_team_en;
    }

    public void setHome_team_en(String home_team_en) {
        this.home_team_en = home_team_en;
    }

    public String getHome_flag() {
        return home_flag;
    }

    public void setHome_flag(String home_flag) {
        this.home_flag = home_flag;
    }

    public String getAway_flag() {
        return away_flag;
    }

    public void setAway_flag(String away_flag) {
        this.away_flag = away_flag;
    }

    public String getAway_score() {
        return away_score;
    }

    public void setAway_score(String away_score) {
        this.away_score = away_score;
    }

    public String getHome_score() {
        return home_score;
    }

    public void setHome_score(String home_score) {
        this.home_score = home_score;
    }

    public String getLocal_date() {
        return local_date;
    }

    public void setLocal_date(String local_date) {
        this.local_date = local_date;
    }


}
