package ua.twotwo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Station {
    private String title;
    @JsonProperty("station_id")
    private String id;
    @JsonProperty("src_date")
    private String date;//this field for set data arrive/departure

    public Station() {
    }

    public Station(String title, String id) {
        this.title = title;
        this.id = id;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("station")
    public String getStation() {
        return title;
    }

    public void setStation(String station) {
        this.title = station;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
