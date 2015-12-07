package ua.twotwo.service.impl;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import static org.mockito.Mockito.*;

import java.util.Collection;
import java.util.Collections;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ua.twotwo.dao.entity.DaoStation;
import ua.twotwo.dao.repository.StationRepository;
import ua.twotwo.dto.Station;
import ua.twotwo.service.SaverStationService;

import com.google.common.collect.Lists;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/beans.xml", "/db.xml" })
public class SaverStationServiceImplTest {
    @InjectMocks
    @Autowired
    private SaverStationService saverStationService;
    @Mock
    private StationRepository stationRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSaveCrossStations() throws Exception {
        when(stationRepository.save(Matchers.anyCollection())).thenReturn(Collections.emptyList());

        final Station uzStationTest1 = new Station("test1", "1");
        final Station uzStationTest2 = new Station("test2", "2");
        final Station bookingStationTest1 = new Station("test1", "100500");
        final Station bookingStationTest3 = new Station("test3", "3");

        final Collection<Station> uzStations = Lists.newArrayList(uzStationTest1,uzStationTest2);
        final Collection<Station> bookingStations = Lists.newArrayList(bookingStationTest1,bookingStationTest3);

        Collection<DaoStation> savedStations = saverStationService.saveEqualsByTitleStations(uzStations, bookingStations);
        assertTrue(savedStations.size()==1);
    }
}