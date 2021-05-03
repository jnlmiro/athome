package org.jorgma.athome.sl.domain;

/**
 * Created by jorgma on 2021-04-14.
 */
public class DepartureTransport {
    private String destination;
    private String line;
    private int direction;
    private String transportType;
    private String transportSubType;

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public String getTransportType() {
        return transportType;
    }

    public void setTransportType(String transportType) {
        this.transportType = transportType;
    }

    public String getTransportSubType() {
        return transportSubType;
    }

    public void setTransportSubType(String transportSubType) {
        this.transportSubType = transportSubType;
    }
}
