package ua.twotwo.service.impl;

import java.util.Collection;
import java.util.Iterator;

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
    public void saveAndCutCrossStations(Collection<Station> uzStations, Collection<Station> bookingStations) {
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
        Iterable<DaoStation> savedStations = stationsRepository.save(daoStations);
        LOGGER.debug(String.format(INFO.SAVED_STATIONS, Iterables.size(savedStations)));
    }
}
