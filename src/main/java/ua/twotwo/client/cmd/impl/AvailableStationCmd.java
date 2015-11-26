package ua.twotwo.client.cmd.impl;

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

public class AvailableStationCmd extends AbstractCmd {
    private final String URL = "http://booking.uz.gov.ua/en/purchase/search/";
    public static final String BOOKING_URL = "http://booking.uz.gov.ua/";
    private static final String REQUEST_BODY_TEMPLATE = "station_id_from=%s&station_id_till=%s&date_dep=%s&time_dep=00:00&time_dep_till=24:00";

    public AvailableStationCmd(final Integer fromId, final Integer toId, final String time) {
        setRequestBody(prepareRequestBody(fromId, toId, time));
        fillHeaders();
        setUrl(URL);
        setMethod(POST);
        setResponseType(BookingTrainAnswer.class);
    }

    private String prepareRequestBody(final Integer fromId, final Integer toId, final String time) {
        return String.format(REQUEST_BODY_TEMPLATE, fromId, toId, time);
    }

    private void fillHeaders() {
        try {
            final URL url = new URL(BOOKING_URL);
            final HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            final String htmlPage = getHTMLPage(conn.getInputStream());
            final Map headers = getHeaders(conn);
            addHeader("Cookie", getCookieSessId(headers));
            addHeader("GV-Token", getToken(htmlPage));
            addHeader("GV-Ajax", "1");
            addHeader("Content-Type", "application/x-www-form-urlencoded");
            addHeader("Referer", "http://booking.uz.gov.ua/en/");
        } catch (Exception e) {
            throw new RuntimeException("Some problems with fill headers ", e);
        }


    }

    private String getHTMLPage(final InputStream inputStream) throws IOException {
        String html = EMPTY;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = reader.readLine()) != null) {
                html += line;
            }
        }
        return html;
    }

    private Map<String, List<String>> getHeaders(final HttpURLConnection conn) {
        return conn.getHeaderFields();
    }

    private String getCookieSessId(Map<String, List<String>> headers) {
        String cookieSessId = EMPTY;
        if (headers.containsKey("Set-Cookie")) {
            for (String current_cookie : headers.get("Set-Cookie")) {
                if (current_cookie.startsWith("_gv_sessid")) {
                    cookieSessId = current_cookie;
                    break;
                }
            }
        }
        return cookieSessId;
    }

    private String getToken(final String htmlPage) throws ScriptException {
        String token = EMPTY;
        String adapter = "var token;localStorage={setItem:function(key, value){if(key==='gv-token')token=value}};";
        Pattern pattern = Pattern.compile("\\$\\$_=.*~\\[\\];.*\"\"\\)\\(\\)\\)\\(\\);");
        Matcher matcher = pattern.matcher(htmlPage);
        if (matcher.find()) {
            String obfuscated = matcher.group(0);
            ScriptEngineManager factory = new ScriptEngineManager();
            ScriptEngine engine = factory.getEngineByName("JavaScript");
            engine.eval(adapter + obfuscated);
            token = engine.get("token").toString();
        }
        return token;
    }
}
