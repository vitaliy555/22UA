package ua.twotwo.client.cmd.impl;

import ua.twotwo.client.cmd.AbstractCmd;
import ua.twotwo.dto.booking.BookingStationAnswer;

public class BookingStationCmd extends AbstractCmd {

    private final String url = "http://booking.uz.gov.ua/purchase/station/";

    public BookingStationCmd() {
        setUrl(url);
        setResponseType(BookingStationAnswer.class);
    }
}
