package ua.twotwo.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ua.twotwo.enity.Station;
import ua.twotwo.service.StationService;

import java.util.Collection;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/beans.xml" })
public class StationServiceImplTest {
    @Autowired
    private StationService stationService;

    @Test
    public void testGetBookingStations() throws Exception {
         stationService.getBookingStations();
        System.out.println();
    }

    @Test
    public void testGetUzStations() throws Exception {
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
//        converter.
    }
}