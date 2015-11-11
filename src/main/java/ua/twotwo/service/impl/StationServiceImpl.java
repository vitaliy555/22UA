package ua.twotwo.service.impl;

import java.util.Collection;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import ua.twotwo.client.RestClient;
import ua.twotwo.client.cmd.impl.BookingStationCmd;
import ua.twotwo.client.cmd.impl.UzStationCmd;
import ua.twotwo.dto.Station;
import ua.twotwo.dto.booking.BookingStationAnswer;
import ua.twotwo.service.StationService;
import ua.twotwo.utils.AlphabetBean;

import com.google.common.collect.Lists;

public class StationServiceImpl implements StationService {
    private static final Logger LOGGER = Logger.getLogger(StationServiceImpl.class);

    @Autowired
    private RestClient restClient;
    @Autowired
    private AlphabetBean alphabetBean;

    @Override
    public Collection<Station> getBookingStations() {
        final Collection<Station> stations = Lists.newArrayList();
        final BookingStationCmd bookingStationCmd = new BookingStationCmd();
        for (String letter : alphabetBean.getCyrillicAlphabet()) {
            bookingStationCmd.setPathParam(letter);
            final ResponseEntity<BookingStationAnswer> response = restClient.execCmd(bookingStationCmd);
            stations.addAll(response.getBody().getValue());
        }
        return stations;
    }

    @Override
    public Collection<Station> getUzStations() {
        final UzStationCmd uzStationCmd = new UzStationCmd();
        final ResponseEntity<String> response = restClient.execCmd(uzStationCmd);
        return convertToStations(response.getBody());
//        throw new RuntimeException("Method not supported ----> Collection<Station> getUzStations()");
        // return null;
    }

    private Collection<Station> convertToStations(final String stations) {
        String[] stationsData = stations.replace("[", "").split("\",");
        for (String stationData : stationsData) {
            //TODO split
            stationData.replaceAll("\\([à-ÿÀ-ß]+\\)", "");
        }
        LOGGER.debug(stations);
        return null;
    }
    public static final String DELIMITER_TITLE_ID = "~";
    public static final String STATION_COUNTRY_SEPARATOR = "\\(";

}
