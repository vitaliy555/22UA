package ua.twotwo.dto.booking;

import java.util.Collection;

import ua.twotwo.dto.Station;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.Lists;

public class BookingStationAnswer {
    @JsonProperty("value")
    private Collection<Station> value = Lists.newArrayList();
    @JsonProperty("error")
    boolean error;
    @JsonProperty("data")
    Object data;

    public Collection<Station> getValue() {
        return value;
    }

    public void setValue(Collection<Station> value) {
        this.value = value;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
