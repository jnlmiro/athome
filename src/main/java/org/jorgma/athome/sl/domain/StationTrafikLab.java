package org.jorgma.athome.sl.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by jorgma on 2017-12-12.
 */

public class StationTrafikLab {

    private String name;
    private int siteId;
    private String type;
    private int x;
    private int y;


    public StationTrafikLab() {
    }


    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("Name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("siteId")
    public int getSiteId() {
        return siteId;
    }

    @JsonProperty("SiteId")
    public void setSiteId(int siteId) {
        this.siteId = siteId;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("Type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("x")
    public int getX() {
        return x;
    }

    @JsonProperty("X")
    public void setX(int x) {
        this.x = x;
    }

    @JsonProperty("y")
    public int getY() {
        return y;
    }

    @JsonProperty("Y")
    public void setY(int y) {
        this.y = y;
    }


    @Override
    public String toString() {
        return "StationTrafikLab{" +
                "name='" + name + '\'' +
                ", siteId='" + siteId + '\'' +
                ", type='" + type + '\'' +
                ", x='" + x + '\'' +
                ", y='" + y + '\'' +
                '}';
    }
}
