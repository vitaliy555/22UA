package ua.twotwo.dto;

public class Station {
    protected String title;
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

    public String getId() {
        return id;
    }

}
