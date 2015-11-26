package ua.twotwo.dto.booking;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.Lists;
import ua.twotwo.dto.Train;

import java.util.Collection;

public class BookingTrainAnswer {
    @JsonProperty("value")
    private Collection<Train> value = Lists.newArrayList();
    @JsonProperty("error")
    private boolean error;
    @JsonProperty("data")
    private Object data;

    public Collection<Train> getValue() {
        return value;
    }

    public void setValue(Collection<Train> value) {
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
