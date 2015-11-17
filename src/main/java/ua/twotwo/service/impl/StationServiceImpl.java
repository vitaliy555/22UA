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
    public static final String SHARP = "#";
    public static final String TILDE = "~";
    public static final String REPLACE_REGEX = "\\(.+\\)".concat(TILDE);
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
    }

    private Collection<Station> convertToStations(final String stationsData) {
        final Collection<Station> stations = Lists.newArrayList();
        final String[] splitStations = stationsData.replaceAll("\\[ \"", "").split("\", \"");
        for (String stationData : splitStations) {
            final String stationWithOutCountry = stationData.replaceAll(REPLACE_REGEX, SHARP);
            final String[] titleAndId = stationWithOutCountry.contains(SHARP) ? stationWithOutCountry
                    .split(SHARP) : stationWithOutCountry.split(TILDE);
            stations.add(new Station(titleAndId[0].trim(),titleAndId[1].trim()));
        }
        return stations;
    }
}
