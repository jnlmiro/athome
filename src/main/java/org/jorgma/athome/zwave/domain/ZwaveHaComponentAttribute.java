package org.jorgma.athome.zwave.domain;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

/**
 * Created by jorgma on 2018-08-02.
 */
public class ZwaveHaComponentAttribute {
    private String friendlyName;
    private int nodeId;
    private String unitOfMeasurement;
    private String type;
    private String responsibility;


    @JsonGetter(value = "friendlyName")
    public String getFriendlyName() {
        return friendlyName;
    }

    @JsonSetter(value = "friendly_name")
    public void setFriendlyName(String friendlyName) {
        this.friendlyName = friendlyName;
    }

    @JsonGetter(value = "nodeId")
    public int getNodeId() {
        return nodeId;
    }

    @JsonSetter(value = "node_id")
    public void setNodeId(int nodeId) {
        this.nodeId = nodeId;
    }

    @JsonGetter(value = "unitOfMeasurement")
    public String getUnitOfMeasurement() {
        return unitOfMeasurement;
    }

    @JsonSetter(value = "unit_of_measurement")
    public void setUnitOfMeasurement(String unitOfMeasurement) {
        this.unitOfMeasurement = unitOfMeasurement;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getResponsibility() {
        return responsibility;
    }

    public void setResponsibility(String responsibility) {
        this.responsibility = responsibility;
    }
}
