package ua.twotwo.service.impl;

import static org.junit.Assert.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

import java.util.Collection;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

import ua.twotwo.client.cmd.impl.ScheduleStationCmd;
import ua.twotwo.dto.Train;
import ua.twotwo.utils.StubTool;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/beans.xml", "/db.xml" })
public class TrainScheduleServiceImplTest {
    private final String from = "22720";
    private final String to = "23380";
    @Autowired
    private TrainScheduleServiceImpl trainScheduleService;
    @Autowired
    private RestTemplate restTemplate;

    @Before
    public void setUp() throws Exception {
        final ScheduleStationCmd scheduleStationCmd = new ScheduleStationCmd(from, to);
        final MockRestServiceServer mockRestServiceServer = MockRestServiceServer.createServer(restTemplate);
        mockRestServiceServer
                .expect(requestTo(scheduleStationCmd.getUrl()))
                .andExpect(method(scheduleStationCmd.getMethod()))
                .andRespond(
                        withSuccess(StubTool.readStubFromResource("scheduleTrainStub.json"), MediaType.APPLICATION_JSON));

    }

    @Test
    public void testGetScheduleTrains() throws Exception {
        Collection<Train> scheduleTrains = trainScheduleService.getScheduleTrains(from, to);
        assertFalse(scheduleTrains.isEmpty());
        assertTrue(scheduleTrains.size()==26);
        for (Train scheduleTrain : scheduleTrains) {
            assertNotNull(scheduleTrain.getNumber());
            assertNotNull(scheduleTrain.getRoute());
            assertNotNull(scheduleTrain.getSchedule());
        }
    }
}