package ua.twotwo.client.cmd.impl;

import ua.twotwo.client.cmd.AbstractCmd;
import ua.twotwo.enity.Station;

import java.util.List;

public class BookingStationCmd extends AbstractCmd {

    private final String url = "http://booking.uz.gov.ua/purchase/station/";

    public BookingStationCmd() {
        setUrl(url);
        setResponseType(List.class);

    }
}
