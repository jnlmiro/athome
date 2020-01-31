package org.jorgma.athome.sl.domain;

import javax.persistence.*;

/**
 * Created by jorgma on 2017-12-10.
 */

@Entity(name = "stations")
public class Station {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Column(name = "site_id")
    private int siteId;
    private String type;
    private int x;
    private int y;
    private boolean enabled;


    public Station() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSiteId() {
        return siteId;
    }

    public void setSiteId(int siteId) {
        this.siteId = siteId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        return "Station{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", siteId=" + siteId +
                ", type='" + type + '\'' +
                ", x=" + x +
                ", y=" + y +
                ", enabled=" + enabled +
                '}';
    }
}
