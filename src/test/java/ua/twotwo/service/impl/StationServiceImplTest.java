package ua.twotwo.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ua.twotwo.dto.Station;
import ua.twotwo.service.StationService;

import java.util.Collection;

import static junit.framework.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/beans.xml" })
public class StationServiceImplTest {
    @Autowired
    private StationService stationService;

    @Test
    public void testGetBookingStations() throws Exception {
        Collection<Station> bookingStations = stationService.getBookingStations();
       assertFalse(bookingStations.isEmpty());
    }

    @Test
    public void testGetUzStations() throws Exception {
    }
}