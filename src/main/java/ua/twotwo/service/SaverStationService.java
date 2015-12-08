package ua.twotwo.service;

import java.util.Collection;

import ua.twotwo.dao.entity.DaoStation;
import ua.twotwo.dto.Station;

/**
 * Service for save stations to DB 
 */
public interface SaverStationService {
    /**
     * Save into DB and remove from collections equals by title stations
     * @param uzStations the uzStations
     * @param bookingStations the bookingStations
     */
    void saveEqualsByTitleStations(final Collection<Station> uzStations, final Collection<Station> bookingStations);
}
