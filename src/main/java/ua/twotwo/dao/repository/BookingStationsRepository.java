package ua.twotwo.dao.repository;

import org.springframework.data.repository.CrudRepository;
import ua.twotwo.dao.entity.BookingDaoStation;
import ua.twotwo.dao.entity.BookingStation;
import ua.twotwo.dao.entity.DaoStation;

/**
 * Stations from booking
 */
public interface BookingStationsRepository extends CrudRepository<DaoStation,Long> {

}
