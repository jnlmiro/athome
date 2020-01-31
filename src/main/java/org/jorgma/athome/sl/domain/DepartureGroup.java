package org.jorgma.athome.sl.domain;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.List;

/**
 * Created by jorgma on 2017-10-27.
 */
public class DepartureGroup {
    private List<Departure> departures;
    private String groupId;
    private String currentServerTime;
    private String type;
    private String title;
    private int journeyProduct;
    private String transportSymbol;

    @JsonGetter(value = "departures")
    public List<Departure> getDepartures() {
        return departures;
    }

    @JsonSetter(value = "Departures")
    public void setDepartures(List<Departure> departures) {
        this.departures = departures;
    }

    @JsonGetter(value = "groupId")
    public String getGroupId() {
        return groupId;
    }

    @JsonSetter(value = "GroupId")
    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    @JsonGetter(value = "currentServerTime")
    public String getCurrentServerTime() {
        return currentServerTime;
    }

    @JsonSetter(value = "CurrentServerTime")
    public void setCurrentServerTime(String currentServerTime) {
        this.currentServerTime = currentServerTime;
    }

    @JsonGetter(value = "type")
    public String getType() {
        return type;
    }

    @JsonSetter(value = "Type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonGetter(value = "title")
    public String getTitle() {
        return title;
    }

    @JsonSetter(value = "Title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonGetter(value = "journeyProduct")
    public int getJourneyProduct() {
        return journeyProduct;
    }

    @JsonSetter(value = "JourneyProduct")
    public void setJourneyProduct(int journeyProduct) {
        this.journeyProduct = journeyProduct;
    }

    @JsonGetter(value = "transportSymbol")
    public String getTransportSymbol() {
        return transportSymbol;
    }

    @JsonSetter(value = "TransportSymbol")
    public void setTransportSymbol(String transportSymbol) {
        this.transportSymbol = transportSymbol;
    }
}
