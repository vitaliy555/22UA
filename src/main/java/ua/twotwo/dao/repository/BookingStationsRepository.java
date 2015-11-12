package ua.twotwo.dao.repository;

import org.springframework.data.repository.CrudRepository;
import ua.twotwo.dao.entity.BookingStation;

/**
 * Stations from booking
 */
public interface BookingStationsRepository extends CrudRepository<BookingStation,Long> {

}
