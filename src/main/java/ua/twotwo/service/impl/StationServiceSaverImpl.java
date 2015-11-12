package ua.twotwo.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import ua.twotwo.dao.entity.BookingDaoStation;
import ua.twotwo.dao.entity.DaoStation;
import ua.twotwo.dao.entity.UzDaoStation;
import ua.twotwo.dao.repository.BookingStationsRepository;
import ua.twotwo.dto.Station;
import ua.twotwo.service.StationServiceSaver;

import com.google.common.collect.Lists;

public class StationServiceSaverImpl implements StationServiceSaver {
    @Autowired
    private BookingStationsRepository bookingStRepo;

    @Override
    public void saveBookingStations(final Collection<Station> stations) {
        Collection<DaoStation> daoStations = convertToDaoStations(stations, BookingDaoStation.class);
        bookingStRepo.save(daoStations);
    }

    private Collection<DaoStation> convertToDaoStations(final Collection<Station> stations,
            final Class<? extends DaoStation> daoStationClass) {
        final Collection<DaoStation> daoStations = Lists.newArrayList();
        if (daoStationClass.isAssignableFrom(BookingDaoStation.class)) {
            for (Station station : stations) {
                daoStations.add(new BookingDaoStation(station.getId(), station.getTitle()));
            }
        } else if (daoStationClass.isAssignableFrom(UzDaoStation.class)) {
            // TODO some
        } else {
            throw new RuntimeException("Class not assignable from any ...");
        }
        return daoStations;
    }
}
