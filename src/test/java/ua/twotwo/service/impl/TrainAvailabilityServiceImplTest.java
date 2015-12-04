package ua.twotwo.service.impl;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

import ua.twotwo.client.cmd.impl.AvailableStationCmd;
import ua.twotwo.dto.AvailableTrain;
import ua.twotwo.utils.StubTool;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/beans.xml", "/db.xml" })
public class TrainAvailabilityServiceImplTest {
    @Autowired
    private TrainAvailabilityServiceImpl trainAvailabilityService;
    @Autowired
    private RestTemplate restTemplate;

    @Before
    public void setUp() throws Exception {
        final AvailableStationCmd availableStationCmd = new AvailableStationCmd(anyInt(), anyInt(), anyString());
        final MockRestServiceServer mockRestServiceServer = MockRestServiceServer.createServer(restTemplate);
        mockRestServiceServer
                .expect(requestTo(availableStationCmd.getUrl()))
                .andExpect(method(availableStationCmd.getMethod()))
                .andRespond(
                        withSuccess(StubTool.readStubFromResource("availableTrainStub.json"),
                                MediaType.APPLICATION_JSON));

    }

    @Test
    public void testGetAvailableTrains() throws Exception {
        final Collection<AvailableTrain> availableTrains = trainAvailabilityService.getAvailableTrains(anyInt(),
                anyInt(), anyString());
        assertFalse(availableTrains.isEmpty());
        assertTrue(availableTrains.size() == 2);
    }
}