package ua.twotwo.service.impl;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

import java.util.Collection;
import java.util.Collections;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

import ua.twotwo.client.cmd.impl.BookingStationCmd;
import ua.twotwo.client.cmd.impl.UzStationCmd;
import ua.twotwo.dto.Station;
import ua.twotwo.service.StationService;
import ua.twotwo.utils.AlphabetBean;
import ua.twotwo.utils.StubTool;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/beans.xml", "/db.xml" })
public class StationServiceImplTest {
    private static final String CHAR_D = "D";
    @InjectMocks
    @Autowired
    private StationService stationService;
    @Mock
    private AlphabetBean alphabetBean;
    @Autowired
    private RestTemplate restTemplate;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetBookingStations() throws Exception {
        when(alphabetBean.getCyrillicAlphabet()).thenReturn(Collections.singletonList(CHAR_D));

        final BookingStationCmd bookingStationCmd = new BookingStationCmd();
        bookingStationCmd.setPathParam(CHAR_D);
        final MockRestServiceServer mockRestServiceServer = MockRestServiceServer.createServer(restTemplate);
        mockRestServiceServer
                .expect(requestTo(bookingStationCmd.getUrl()))
                .andExpect(method(bookingStationCmd.getMethod()))
                .andRespond(
                        withSuccess(StubTool.readStubFromResource("bookingStationStub.json"),
                                MediaType.APPLICATION_JSON));
        Collection<Station> bookingStations = stationService.getBookingStations();
        assertFalse(bookingStations.isEmpty());
        Station firstStation = bookingStations.iterator().next();
        assertNotNull(firstStation.getTitle());
        assertNotNull(firstStation.getId());
    }

    @Test
    public void testGetUzStations() throws Exception {
        final UzStationCmd uzStationCmd = new UzStationCmd();
        final MockRestServiceServer mockRestServiceServer = MockRestServiceServer.createServer(restTemplate);
        mockRestServiceServer
                .expect(requestTo(uzStationCmd.getUrl()))
                .andExpect(method(uzStationCmd.getMethod()))
                .andRespond(
                        withSuccess(StubTool.readStubFromResource("uzStationStub.json"),
                                MediaType.APPLICATION_JSON));
        final Collection<Station> uzStations = stationService.getUzStations();
        assertFalse(uzStations.isEmpty());
        Station firstStation = uzStations.iterator().next();
        assertNotNull(firstStation.getTitle());
        assertNotNull(firstStation.getId());
    }
}