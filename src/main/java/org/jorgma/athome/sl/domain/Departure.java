package org.jorgma.athome.sl.domain;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;

/**
 * Created by jorgma on 2017-10-27.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Departure {

    private String expectedDateTime;
    private String stopPointNumber;
    private String displayTime;
    private String lineNumber;
    private String destination;

    @JsonGetter(value = "expectedDateTime")
    public String getExpectedDateTime() {
        return expectedDateTime;
    }

    @JsonSetter(value = "ExpectedDateTime")
    public void setExpectedDateTime(String expectedDateTime) {
        this.expectedDateTime = expectedDateTime;
    }

    @JsonGetter(value = "stopPointNumber")
    public String getStopPointNumber() {
        return stopPointNumber;
    }

    @JsonSetter(value = "StopPointNumber")
    public void setStopPointNumber(String stopPointNumber) {
        this.stopPointNumber = stopPointNumber;
    }

    @JsonGetter(value = "displayTime")
    public String getDisplayTime() {
        return displayTime;
    }

    @JsonSetter(value = "DisplayTime")
    public void setDisplayTime(String displayTime) {
        this.displayTime = displayTime;
    }

    @JsonGetter(value = "lineNumber")
    public String getLineNumber() {
        return lineNumber;
    }

    @JsonSetter(value = "LineNumber")
    public void setLineNumber(String lineNumber) {
        this.lineNumber = lineNumber;
    }

    @JsonGetter(value = "destination")
    public String getDestination() {
        return destination;
    }

    @JsonSetter(value = "Destination")
    public void setDestination(String destination) {
        this.destination = destination;
    }
}
