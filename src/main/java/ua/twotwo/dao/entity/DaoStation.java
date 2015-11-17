package ua.twotwo.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "station")
public class DaoStation {
    @Id
    @Column(name = "idBooking")
    private Long idBooking;
    @Column(name = "idUz")
    private String idUz;
    @Column(name = "title")
    private String title;

    public DaoStation() {
    }

    public DaoStation(Long idBooking, String idUz, String title) {
        this.idBooking = idBooking;
        this.idUz = idUz;
        this.title = title;
    }

    public Long getIdBooking() {
        return idBooking;
    }

    public void setIdBooking(Long idBooking) {
        this.idBooking = idBooking;
    }

    public String getIdUz() {
        return idUz;
    }

    public void setIdUz(String idUz) {
        this.idUz = idUz;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
