package ua.twotwo.service;

import java.util.Collection;

import ua.twotwo.enity.Station;

public interface StationService {
    Collection<Station> getBookingStations();

    Collection<Station> getUzStations();
}
