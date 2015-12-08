package ua.twotwo.service;

import ua.twotwo.dto.Train;

import java.util.Collection;

/**
 * Service for search schedule trains
 */
public interface TrainScheduleService {
    Collection<Train> getScheduleTrains(final String uzIdFrom, final String uzIdTo);

}
