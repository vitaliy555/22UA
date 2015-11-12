package ua.twotwo.dao.entity;

import javax.persistence.Column;
import javax.persistence.Id;

public abstract class DaoStation {
    @Id
    @Column(name = "id")
    protected String id;
    @Column(name = "title")
    protected String title;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
