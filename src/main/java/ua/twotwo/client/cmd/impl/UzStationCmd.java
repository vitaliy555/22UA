package ua.twotwo.client.cmd.impl;

import java.lang.reflect.Array;
import java.util.ArrayList;

import ua.twotwo.client.cmd.AbstractCmd;

public class UzStationCmd extends AbstractCmd {

    private final String url = "http://www.uz.gov.ua/passengers/timetables/suggest-station/?q=";

    public UzStationCmd() {
        setUrl(url);
        setResponseType(String.class);
    }
}
