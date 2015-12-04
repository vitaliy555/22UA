package ua.twotwo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Place {
    @JsonProperty("title")
    private String typePlace;
    @JsonProperty("places")
    private String countPlaces;
    @JsonProperty("letter")
    private String letter;

    public String getTypePlace() {
        return typePlace;
    }

    public void setTypePlace(String typePlace) {
        this.typePlace = typePlace;
    }

    public String getCountPlaces() {
        return countPlaces;
    }

    public void setCountPlaces(String countPlaces) {
        this.countPlaces = countPlaces;
    }

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }
}
