package ua.twotwo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import ua.twotwo.client.RestClient;
import ua.twotwo.client.cmd.impl.AvailableStationCmd;
import ua.twotwo.dto.AvailableTrain;
import ua.twotwo.dto.booking.BookingTrainAnswer;
import ua.twotwo.service.TrainAvailabilityService;

import java.util.Collection;

public class TrainAvailabilityServiceImpl implements TrainAvailabilityService {
    @Autowired
    private RestClient restClient;

    @Override
    public Collection<AvailableTrain> getAvailableTrains(Integer bookingIdFrom, Integer bookingIdTo, String data) {
        final AvailableStationCmd availableStationCmd = new AvailableStationCmd(bookingIdFrom, bookingIdTo, data);
        final ResponseEntity<BookingTrainAnswer> response = restClient.execCmd(availableStationCmd);
        return response.getBody().getValue();
    }
}
