package ua.twotwo.service.impl;

import java.util.Collection;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import ua.twotwo.dao.entity.DaoStation;
import ua.twotwo.dao.repository.StationsRepository;
import ua.twotwo.dto.Station;
import ua.twotwo.service.SaverStationService;
import ua.twotwo.utils.AppConst.INFO;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

public class SaverStationServiceImpl implements SaverStationService {

    private static final Logger LOGGER = Logger.getLogger(SaverStationService.class);

    @Autowired
    private StationsRepository stationsRepository;

    @Override
    public void saveCrossStations(Collection<Station> uzStations, Collection<Station> bookingStations) {
        final Collection<DaoStation> daoStations = Lists.newArrayList();
        for (Station uzStation : uzStations) {
            for (Station bookingStation : bookingStations) {
                if (uzStation.getTitle().equals(bookingStation.getTitle())) {
                    // TODO move this hardcode
                    daoStations.add(new DaoStation(Long.valueOf(bookingStation.getId()), uzStation.getId(), uzStation.getTitle()));
                    stationsRepository.save(daoStations);
                    continue;
                }
            }
        }
        Iterable<DaoStation> savedStations = stationsRepository.save(daoStations);
        LOGGER.debug(String.format(INFO.SAVED_STATIONS, Iterables.size(savedStations)));
    }
}
