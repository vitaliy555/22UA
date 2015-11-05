package ua.twotwo.client.cmd.impl;

import java.util.Collection;
import java.util.List;

import ua.twotwo.client.cmd.AbstractCmd;
import ua.twotwo.converter.booking.dto.BookingStationAnswer;

public class BookingStationCmd extends AbstractCmd {

    private final String url = "http://booking.uz.gov.ua/purchase/station/ly";

    public BookingStationCmd() {
        setUrl(url);
        setResponseType(List.class);

    }
}
