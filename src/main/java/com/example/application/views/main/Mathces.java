package com.example.application.views.main;

import com.example.application.structures.Match;
import com.example.application.structures.MatchResponse;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import com.nimbusds.jose.shaded.json.JSONArray;
import com.nimbusds.jose.shaded.json.JSONObject;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import okhttp3.*;
import okhttp3.internal.http2.Header;

import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;



public class Mathces extends VerticalLayout {
    HorizontalLayout datehoriz;
    String []months={"January","February","March","April","May","June","July","August","September","October","November","December"};
    String []days={"Saturday","Sunday","Monday","Tuesday","Wednesday","Thursday","Friday"};
    Button btnleftarr;
    Button btnrightarr;
    Label datetext;
    int year=0,dayOfMonth=0,month=0;
    LocalDate currentDate ;
    MacthComponent macthComponent,macthComponent1;
    List<Match> dataMatches;
    public Mathces(){

        setWidth("640px");

        setHeightFull();
        currentDate = LocalDate.now(ZoneId.systemDefault());
        addClassName("vertical-date");
        datetext = new Label(""+ currentDate.getDayOfWeek()+", "+months[currentDate.getMonthValue()-1]+" "+currentDate.getDayOfMonth());
        datetext.addClassName("datetext");
        datehoriz =new HorizontalLayout();
        datehoriz.addClassName("horizanel-date");
        btnleftarr=new Button();
        btnrightarr =new Button();
        btnrightarr.addClickListener(event -> nextDay());
        btnleftarr.addClickListener(event -> breviousDay());
        btnrightarr.addClassName("btnright");
        btnleftarr.addClassName("btnleft");
        btnleftarr.setIcon(new Icon(VaadinIcon.ARROW_LEFT));
        btnrightarr.setIcon(new Icon(VaadinIcon.ARROW_RIGHT));
        datehoriz.setAlignItems(Alignment.CENTER);
        datehoriz.add(btnleftarr,datetext,btnrightarr);

        // Code for API Response using okhttp

        OkHttpClient client = new OkHttpClient();

        String url = "http://api.cup2022.ir/api/v1/match";

        Request request = new Request.Builder()
                .header("Authorization" , "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2MzhhYzdkYWYyODA5NGFhM2FhZDVmN2UiLCJpYXQiOjE2NzAwMzk2NTMsImV4cCI6MTY3MDEyNjA1M30.DeNfABbdh1IE7o4PdLm7V8kD1lm8CcFLhZU-8eBcvd4")
                .url(url)
                .build();




        try {
            Response response = client.newCall(request).execute();
            String requestString = response.body().string();

            ObjectMapper objectMapper = new ObjectMapper().disable(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES);

            objectMapper.setVisibility(VisibilityChecker.Std.defaultInstance().withFieldVisibility(JsonAutoDetect.Visibility.ANY));

            MatchResponse match = objectMapper.readValue(requestString, MatchResponse.class);

            dataMatches = match.getData();
            add(datehoriz);

            for (Match i : dataMatches)
            {
                String[] arr = i.getLocal_date().split("/");
                LocalDate date = LocalDate.of(Integer.parseInt(arr[2].split(" ")[0]),Integer.parseInt(arr[0]), Integer.parseInt(arr[1]));
                if(currentDate.equals(date))
                    add(new MacthComponent(i.getAway_team_en(), i.getHome_team_en(), i.getAway_flag(), i.getHome_flag(), i.getAway_score(), ":", i.getHome_score(),i.getLocal_date(), i));
                System.out.println(i.getLocal_date());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }






//        macthComponent=new MacthComponent("portugal","Argenten","https://www.pngkey.com/png/detail/263-2633851_argentina-logo-png-transparent-argentina-flag.png","https://www.pngkey.com/png/detail/263-2633851_argentina-logo-png-transparent-argentina-flag.png","2",":","1");
//        macthComponent1=new MacthComponent("portugal","Argenten","https://www.pngkey.com/png/detail/263-2633851_argentina-logo-png-transparent-argentina-flag.png","https://www.pngkey.com/png/detail/263-2633851_argentina-logo-png-transparent-argentina-flag.png","3",":","3");
//
//        add(datehoriz,macthComponent,macthComponent1);


    }
    private void update()
    {
        this.removeAll();
        add(datehoriz);
        for (Match i : dataMatches) {
            String[] arr = i.getLocal_date().split("/");
            LocalDate date = LocalDate.of(Integer.parseInt(arr[2].split(" ")[0]),Integer.parseInt(arr[0]), Integer.parseInt(arr[1]));
            if(currentDate.equals(date))
                add(new MacthComponent(i.getAway_team_en(), i.getHome_team_en(), i.getAway_flag(), i.getHome_flag(), i.getAway_score(), ":", i.getHome_score(),i.getLocal_date(), i));

        }
    }
    public void nextDay(){
        currentDate= currentDate.plusDays(1);
        datetext.setText(""+ currentDate.getDayOfWeek()+", "+months[currentDate.getMonthValue()-1]+" "+currentDate.getDayOfMonth());

        update();
    }
    public void breviousDay(){
        currentDate= currentDate.minusDays(1);
        datetext.setText(""+ currentDate.getDayOfWeek()+", "+months[currentDate.getMonthValue()-1]+" "+currentDate.getDayOfMonth());
        update();

    }



}
