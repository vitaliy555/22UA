package ua.twotwo.service.impl;

import java.util.Collection;

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
    public Collection<DaoStation> saveEqualsByTitleStations(Collection<Station> uzStations,
            Collection<Station> bookingStations) {
        final Collection<DaoStation> stationsEqualsByTitle = getStationsEqualsByTitle(uzStations, bookingStations);
        LOGGER.debug("Try save stations");
        stationRepository.save(stationsEqualsByTitle);
        LOGGER.debug("Stations saved successful");
        return stationsEqualsByTitle;
    }

    private Collection<DaoStation> getStationsEqualsByTitle(final Collection<Station> uzStations,
            final Collection<Station> bookingStations) {
        final Collection<DaoStation> daoStationsEqualsByTitle = Lists.newArrayList();
        for (Station uzStation : uzStations) {
            for (Station bookingStation : bookingStations) {
                if (uzStation.getTitle().equals(bookingStation.getTitle())) {
                    daoStationsEqualsByTitle.add(new DaoStation(Integer.valueOf(bookingStation.getId()), uzStation
                            .getId(), uzStation.getTitle()));
                    break;
                }
            }
        }
        return daoStationsEqualsByTitle;
    }
}
