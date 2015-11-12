package ua.twotwo.service;

import java.util.Collection;

import ua.twotwo.dto.Station;

public interface StationServiceSaver {
    void saveBookingStations(final Collection<Station> stations);
}
