package ua.twotwo.service;

import java.util.Collection;

import ua.twotwo.dto.AvailableTrain;
import ua.twotwo.dto.Train;

public interface TrainAvailabilityService {
    Collection<AvailableTrain> getAvailableTrains(final Integer bookingIdFrom, final Integer bookingIdTo, final String data);
}
