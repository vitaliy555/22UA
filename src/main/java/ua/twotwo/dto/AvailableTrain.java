package ua.twotwo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.Lists;

import java.util.Collection;

public class AvailableTrain extends AbstractTrain {
    @JsonProperty("types")
    private Collection<Place> availablePlaces = Lists.newArrayList();

    public Collection<Place> getAvailablePlaces() {
        return availablePlaces;
    }

    public void setAvailablePlaces(Collection<Place> availablePlaces) {
        this.availablePlaces = availablePlaces;
    }



    @JsonProperty("num")
    @Override
    protected String getTrainNumber() {
        return super.getTrainNumber();
    }

    @JsonProperty("from")
    @Override
    protected Station getFrom() {
        return super.getFrom();
    }

    @JsonProperty("till")
    @Override
    protected Station getTill() {
        return super.getTill();
    }
}
