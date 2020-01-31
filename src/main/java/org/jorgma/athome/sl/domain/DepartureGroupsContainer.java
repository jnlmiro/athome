package org.jorgma.athome.sl.domain;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.List;

/**
 * Created by jorgma on 2018-03-17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DepartureGroupsContainer {

    private List<BusDepartureGroup> busDepartureGroups;
    private List<MetroDepartureGroup> metroDepartureGroups;
    private boolean hasStopPointDeviations;
    private String lastUpdate;
    private boolean hasResultData;


    @JsonGetter(value = "busGroups")
    public List<BusDepartureGroup> getBusDepartureGroups() {
        return busDepartureGroups;
    }

    @JsonSetter(value = "BusGroups")
    public void setBusDepartureGroups(List<BusDepartureGroup> busDepartureGroups) {
        this.busDepartureGroups = busDepartureGroups;
    }

    @JsonGetter(value = "metroGroups")
    public List<MetroDepartureGroup> getMetroDepartureGroups() {
        return metroDepartureGroups;
    }

    @JsonSetter(value = "MetroGroups")
    public void setMetroDepartureGroups(List<MetroDepartureGroup> metroDepartureGroups) {
        this.metroDepartureGroups = metroDepartureGroups;
    }

    @JsonGetter(value = "hasResultData")
    public boolean isHasResultData() {
        return hasResultData;
    }

    @JsonSetter(value = "HasResultData")
    public void setHasResultData(boolean hasResultData) {
        this.hasResultData = hasResultData;
    }

    @JsonGetter(value = "hasStopPointDeviations")
    public boolean isHasStopPointDeviations() {
        return hasStopPointDeviations;
    }

    @JsonSetter(value = "HasStopPointDeviations")
    public void setHasStopPointDeviations(boolean hasStopPointDeviations) {
        this.hasStopPointDeviations = hasStopPointDeviations;
    }

    @JsonGetter(value = "lastUpdate")
    public String getLastUpdate() {
        return lastUpdate;
    }

    @JsonSetter(value = "LastUpdate")
    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
