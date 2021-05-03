package org.jorgma.athome.sl.domain;

/**
 * Created by jorgma on 2021-04-14.
 */
public class DepartureTime {

    private String timeTabledDateTime;
    private String expectedDateTime;
    private String displayTime;

    public String getTimeTabledDateTime() {
        return timeTabledDateTime;
    }

    public void setTimeTabledDateTime(String timeTabledDateTime) {
        this.timeTabledDateTime = timeTabledDateTime;
    }

    public String getExpectedDateTime() {
        return expectedDateTime;
    }

    public void setExpectedDateTime(String expectedDateTime) {
        this.expectedDateTime = expectedDateTime;
    }

    public String getDisplayTime() {
        return displayTime;
    }

    public void setDisplayTime(String displayTime) {
        this.displayTime = displayTime;
    }
}
