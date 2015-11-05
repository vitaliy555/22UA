package ua.twotwo.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import ua.twotwo.client.RestClient;
import ua.twotwo.client.cmd.impl.BookingStationCmd;
import ua.twotwo.enity.Station;
import ua.twotwo.service.StationService;

public class StationServiceImpl implements StationService {

    @Autowired
    private RestClient restClient;

    @Override
    public Collection<Station> getBookingStations() {
        final BookingStationCmd bookingStationCmd = new BookingStationCmd();
        final ResponseEntity<Collection<Station>> response = restClient.execCmd(bookingStationCmd);
        return response.getBody();
    }

    @Override
    public Collection<Station> getUzStations() {
        throw new RuntimeException("Method not supported ----> Collection<Station> getUzStations()");
        // return null;
    }
}
