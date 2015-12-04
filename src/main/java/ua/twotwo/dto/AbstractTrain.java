package ua.twotwo.dto;

public abstract class AbstractTrain {

    private String trainNumber;
    private Station from;
    private Station till;

    protected String getTrainNumber() {
        return trainNumber;
    }

    protected void setTrainNumber(String trainNumber) {
        this.trainNumber = trainNumber;
    }

    protected Station getFrom() {
        return from;
    }

    protected void setFrom(Station from) {
        this.from = from;
    }

    protected Station getTill() {
        return till;
    }

    protected void setTill(Station till) {
        this.till = till;
    }
}
