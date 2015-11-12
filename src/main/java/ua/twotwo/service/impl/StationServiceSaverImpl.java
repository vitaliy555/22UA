package ua.twotwo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import ua.twotwo.dao.repository.BookingStationsRepository;
import ua.twotwo.dto.Station;
import ua.twotwo.service.StationServiceSaver;

import java.util.Collection;

public class StationServiceSaverImpl implements StationServiceSaver {
    @Autowired
    private BookingStationsRepository bookingStRepo;


    @Override
    public void saveBookingStations(Collection<Station> stations) {
        bookingStRepo.save(stations);
    }
}
