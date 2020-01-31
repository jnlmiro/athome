package org.jorgma.athome.sl.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;

/**
 * Created by jorgma on 2018-03-17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SlDeparturesRestApiResponse {
    private int ms;
    private String status;
    private DepartureGroupsContainer data;


    public int getMs() {
        return ms;
    }

    public void setMs(int ms) {
        this.ms = ms;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public DepartureGroupsContainer getData() {
        return data;
    }

    @JsonSetter(value = "data")
    public void setData(DepartureGroupsContainer data) {
        this.data = data;
    }

}
