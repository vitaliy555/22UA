package ua.twotwo.service.impl;

import ua.twotwo.dto.Train;
import ua.twotwo.service.TrainAvailabilityService;

import java.util.Collection;

public class TrainAvailabilityServiceImpl implements TrainAvailabilityService {
    @Override
    public Collection<Train> getAvailableTrains(Integer bookingIdFrom, Integer bookingIdTo, String data) {
        return null;
    }
}
