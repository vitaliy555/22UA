package ua.twotwo.dto;


import com.fasterxml.jackson.annotation.JsonProperty;

public class Station {
    @JsonProperty("title")
    protected String title;
    @JsonProperty("station_id")
    protected String id;

    public Station() {
    }

    public Station(String title, String id) {
        this.title = title;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
