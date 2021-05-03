package org.jorgma.athome.sl.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.List;

/**
 * Created by jorgma on 2018-03-17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SlDeparturesRestApiResponse {
    private List<Departure> departures;


    public List<Departure> getDepartures() {
        return departures;
    }

    public void setDepartures(List<Departure> departures) {
        this.departures = departures;
    }
}
