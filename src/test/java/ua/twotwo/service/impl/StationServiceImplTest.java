package ua.twotwo.service.impl;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertNotNull;

import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ua.twotwo.dto.Station;
import ua.twotwo.service.StationService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/beans.xml", "/db.xml" })
public class StationServiceImplTest {
    @Autowired
    private StationService stationService;

    @Test
    public void testGetBookingStations() throws Exception {
        Collection<Station> bookingStations = stationService.getBookingStations();
        assertFalse(bookingStations.isEmpty());
        Station firstStation = bookingStations.iterator().next();
        assertNotNull(firstStation.getTitle());
        assertNotNull(firstStation.getId());
    }

    @Test
    public void testGetUzStations() throws Exception {
    }
}