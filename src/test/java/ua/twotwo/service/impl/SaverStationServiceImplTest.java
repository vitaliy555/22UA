package ua.twotwo.service.impl;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

import java.util.Collection;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ua.twotwo.dto.Station;
import ua.twotwo.service.SaverStationService;

import com.google.common.collect.Lists;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/beans.xml", "/db.xml" })
public class SaverStationServiceImplTest {
    @Autowired
    private SaverStationService saverStationService;

    @Ignore
    @Test
    public void testSaveCrossStations() throws Exception {
        Station dnStation = new Station("DN", "1");
        Station dzStation = new Station("DZ", "2");
        Collection<Station> uzStations = Lists.newArrayList(dnStation, dzStation);
        Collection<Station> bookingStations = Lists.newArrayList(dnStation);
        saverStationService.saveCrossStations(uzStations, bookingStations);
        assertFalse(uzStations.isEmpty());
        assertTrue(bookingStations.isEmpty());
    }
}