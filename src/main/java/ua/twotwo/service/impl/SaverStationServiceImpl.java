package ua.twotwo.service.impl;

import java.util.Collection;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import ua.twotwo.dao.entity.DaoStation;
import ua.twotwo.dao.repository.StationRepository;
import ua.twotwo.dto.Station;
import ua.twotwo.service.SaverStationService;

import com.google.common.collect.Lists;

public class SaverStationServiceImpl implements SaverStationService {
    private static final Logger LOGGER = Logger.getLogger(SaverStationService.class);
    @Autowired
    private StationRepository stationRepository;

    @Override
    public void saveEqualsByTitleStations(Collection<Station> uzStations,
            Collection<Station> bookingStations) {
        final Collection<DaoStation> stationsEqualsByTitle = getStationsEqualsByTitleAndRemoveItFromCollections(uzStations, bookingStations);
        LOGGER.debug("Try save stations");
        stationRepository.save(stationsEqualsByTitle);
        LOGGER.debug("Stations saved successful");
    }

    private Collection<DaoStation> getStationsEqualsByTitleAndRemoveItFromCollections(final Collection<Station> uzStations,
            final Collection<Station> bookingStations) {
        final Collection<DaoStation> daoStations = Lists.newArrayList();
        for (Iterator<Station> uzIterator = uzStations.iterator(); uzIterator.hasNext();) {
            Station uzStation = uzIterator.next();
            for (Iterator<Station> bookingIterator = bookingStations.iterator(); bookingIterator.hasNext();) {
                Station bookingStation = bookingIterator.next();
                if (uzStation.getTitle().equals(bookingStation.getTitle())) {
                    daoStations.add(new DaoStation(Integer.valueOf(bookingStation.getId()), uzStation.getId(), uzStation
                            .getTitle()));
                    uzIterator.remove();
                    bookingIterator.remove();
                    break;
                }
            }
        }
        return daoStations;
    }
}
