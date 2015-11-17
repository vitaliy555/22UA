package ua.twotwo.service;

import java.util.Collection;

import ua.twotwo.dto.Station;

public interface SaverStationService {
    void saveCrossStations(final Collection<Station> uzStations,final Collection<Station> bookingStations);
}
