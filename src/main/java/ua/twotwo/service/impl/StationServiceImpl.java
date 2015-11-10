package ua.twotwo.service.impl;

import java.util.Collection;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import ua.twotwo.client.RestClient;
import ua.twotwo.client.cmd.impl.BookingStationCmd;
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
            if (response.getStatusCode() == HttpStatus.OK) {
                stations.addAll(response.getBody().getValue());
            } else {
                LOGGER.warn("Station start with : " + letter + " is absent");
            }
        }
        return stations;
    }

    @Override
    public Collection<Station> getUzStations() {
        throw new RuntimeException("Method not supported ----> Collection<Station> getUzStations()");
        // return null;
    }

}
