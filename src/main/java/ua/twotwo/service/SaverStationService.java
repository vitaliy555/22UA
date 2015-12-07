package ua.twotwo.service;

import java.util.Collection;

import ua.twotwo.dao.entity.DaoStation;
import ua.twotwo.dto.Station;

/**
 * Service for save stations to DB 
 */
public interface SaverStationService {
    /**
     * Save into DB only equals bt title stations
     * @param uzStations the uzStations
     * @param bookingStations the bookingStations
     * @return saved stations
     */
    Collection<DaoStation> saveEqualsByTitleStations(final Collection<Station> uzStations, final Collection<Station> bookingStations);
}
