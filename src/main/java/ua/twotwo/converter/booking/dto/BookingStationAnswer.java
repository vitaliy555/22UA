package ua.twotwo.converter.booking.dto;

import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.Lists;
import ua.twotwo.enity.Station;
// TODO refactoring for convertor
public class BookingStationAnswer {
    private Collection<Station> value = Lists.newArrayList();
    boolean error;
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
