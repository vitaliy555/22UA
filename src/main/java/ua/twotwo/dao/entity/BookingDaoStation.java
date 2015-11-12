package ua.twotwo.dao.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "BookingStation")
public class BookingDaoStation extends DaoStation {
    public BookingDaoStation(String id, String title) {
        this.id = id;
        this.title = title;
    }
}
