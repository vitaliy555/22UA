package ua.twotwo.client.cmd.impl;

import com.google.common.base.Preconditions;
import ua.twotwo.client.cmd.AbstractCmd;
import ua.twotwo.dto.booking.BookingTrainAnswer;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.springframework.http.HttpMethod.POST;

public class ScheduleStationCmd extends AbstractCmd {
    private static final String URL = "http://www.uz.gov.ua/passengers/timetable/?from_station=%s&to_station=%s&by_route=1";
    public ScheduleStationCmd(final String from, final String to) {
        Preconditions.checkNotNull(from,"Argument FROM can't be null");
        Preconditions.checkNotNull(to,"Argument TO can't be null");
        setUrl(String.format(URL, from, to));
        setResponseType(String.class);
    }
}
