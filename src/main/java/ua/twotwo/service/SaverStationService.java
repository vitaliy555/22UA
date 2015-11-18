package ua.twotwo.service;

import java.util.Collection;

import ua.twotwo.dto.Station;

/**
 * Service for save stations to DB 
 */
public interface SaverStationService {
    /**
     * Save into DB and cut cross stations from collections
     * @param uzStations the uzStations 
     * @param bookingStations the bookingStations
     */
    void saveAndCutCrossStations(final Collection<Station> uzStations, final Collection<Station> bookingStations);
}
