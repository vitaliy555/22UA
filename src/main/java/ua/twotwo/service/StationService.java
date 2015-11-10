package ua.twotwo.service;

import java.util.Collection;

import ua.twotwo.dto.Station;

public interface StationService {
    Collection<Station> getBookingStations();

    Collection<Station> getUzStations();
}
