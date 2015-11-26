package ua.twotwo.service.impl;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ua.twotwo.client.RestClient;
import ua.twotwo.client.cmd.impl.AvailableStationCmd;
import ua.twotwo.dto.booking.BookingTrainAnswer;

import static org.junit.Assert.assertFalse;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/beans.xml", "/db.xml"})
public class TrainAvailabilityServiceImplTest {
    @Autowired
    RestClient client;

    private final String currentDate = DateTimeFormat.forPattern("MM.dd.YYYY").print(new DateTime());
    private final int from = 2208001;
    private final int to = 2218000;


    @Test
    public void testGetAvailableTrains() throws Exception {
        AvailableStationCmd availableStationCmd = new AvailableStationCmd(from, to, currentDate);
        ResponseEntity<BookingTrainAnswer> response = client.execCmd(availableStationCmd);
        assertFalse(response.getBody().isError());
        assertFalse(response.getBody().getValue().isEmpty());
    }
}