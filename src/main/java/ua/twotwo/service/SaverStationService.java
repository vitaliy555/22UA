package ua.twotwo.service;

import java.util.Collection;

import ua.twotwo.dto.Station;

/**
 * Service for save stations to DB 
 */
public interface SaverStationService {
    /**
     * Save cross stations
     * @param uzStations the uzStations 
     * @param bookingStations the bookingStations
     */
    void saveCrossStations(final Collection<Station> uzStations, final Collection<Station> bookingStations);
}
