package ua.twotwo.enity;

public class Station {
    private String title;
    private String station_id;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    /**
     * Sets new station_id.
     *
     * @param station_id New value of station_id.
     */
    public void setStation_id(String station_id) {
        this.station_id = station_id;
    }

    /**
     * Gets station_id.
     *
     * @return Value of station_id.
     */
    public String getStation_id() {
        return station_id;
    }
}
