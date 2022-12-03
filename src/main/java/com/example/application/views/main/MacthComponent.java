package com.example.application.views.main;

import com.example.application.structures.Match;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class MacthComponent extends HorizontalLayout {
    VerticalLayout verTeam1;
    VerticalLayout verTeam2;
    VerticalLayout verResult;
    Label res1;
    Label res2;
    Label nopp;
    HorizontalLayout horRes;
    Label team1Name;
    Label team2Name;
    Image team1Img;
    Image team2Img;
    public MacthComponent(Match match)
    {
        team1Name.setText(match.getAway_team_en());
        team2Name.setText(match.getHome_team_en());

        team1Img.setSrc(match.getAway_flag());
        team2Img.setSrc(match.getHome_flag());

        res1.setText(match.getAway_score());
        res2.setText(match.getHome_score());

    }
    public MacthComponent(String team1, String team2, String teamImg1, String teamImg2 ,String scoreTeam1,String nop,String scoreTeam2,Match match){

        team1Name.setText(match.getAway_team_en());
        team2Name.setText(match.getHome_team_en());

        team1Img.setSrc(match.getAway_flag());
        team2Img.setSrc(match.getHome_flag());

        res1.setText(match.getAway_score());
        res2.setText(match.getHome_score());
        addClassName("match-component");
    setWidthFull();
    addClassName("match");
    verTeam1=new VerticalLayout();
    verTeam2=new VerticalLayout();
    verResult=new VerticalLayout();
    res1=new Label(scoreTeam1);
    res2=new Label(scoreTeam2);
    nopp=new Label(nop);
    horRes=new HorizontalLayout();
    horRes.add(res1,nopp,res2);
    horRes.addClassName("result");
    verResult.add(horRes);
    verTeam1.addClassName("ver-team");
    verTeam2.addClassName("ver-team");
    team1Name  =new Label(team1);
    team2Name=new Label(team2);
    team1Name.addClassName("team-name");
    team2Name.addClassName("team-name");
    team1Img= new Image(teamImg1,"team 1 Image");
    team2Img= new Image(teamImg2,"team 2 Image");
    team1Img.addClassName("image");
    team2Img.addClassName("image");
    verTeam1.add(team1Img,team1Name);
    verTeam2.add(team2Img,team2Name);
    verResult.setAlignItems(Alignment.CENTER);
    verResult.setJustifyContentMode(JustifyContentMode.CENTER);
    add(verTeam1,verResult,verTeam2);


    }
}
