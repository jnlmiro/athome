package org.jorgma.athome.sl.domain;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.List;

/**
 * Created by jorgma on 2017-10-27.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Departure {

    private String destination;
    private String stopAreaName;
    private int journeyNumber;

    @JsonSetter(value = "time")
    private DepartureTime departureTime;

    @JsonSetter(value = "transport")
    private DepartureTransport departureTransport;

    @JsonSetter(value = "deviations")
    private List<DepartureDeviation> departureDeviations;

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getStopAreaName() {
        return stopAreaName;
    }

    public void setStopAreaName(String stopAreaName) {
        this.stopAreaName = stopAreaName;
    }

    public int getJourneyNumber() {
        return journeyNumber;
    }

    public void setJourneyNumber(int journeyNumber) {
        this.journeyNumber = journeyNumber;
    }

    @JsonGetter(value="time")
    public DepartureTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(DepartureTime departureTime) {
        this.departureTime = departureTime;
    }

    @JsonGetter(value = "transport")
    public DepartureTransport getDepartureTransport() {
        return departureTransport;
    }

    public void setDepartureTransport(DepartureTransport departureTransport) {
        this.departureTransport = departureTransport;
    }

    @JsonGetter(value="deviations")
    public List<DepartureDeviation> getDepartureDeviations() {
        return departureDeviations;
    }

    public void setDepartureDeviations(List<DepartureDeviation> departureDeviations) {
        this.departureDeviations = departureDeviations;
    }
}
