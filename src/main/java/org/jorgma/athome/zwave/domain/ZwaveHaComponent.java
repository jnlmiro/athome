package org.jorgma.athome.zwave.domain;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

/**
 * Created by jorgma on 2018-07-30.
 */

public class ZwaveHaComponent {

    private String id;
    private String state;
    private ZwaveHaComponentAttribute attributes;

    @JsonGetter(value = "id")
    public String getId() {
        return id;
    }

    @JsonSetter(value = "entity_id")
    public void setId(String id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public ZwaveHaComponentAttribute getAttributes() {
        return attributes;
    }

    public void setAttributes(ZwaveHaComponentAttribute attributes) {
        this.attributes = attributes;
    }

    public boolean isSensor() {
        if (attributes.getType() == null || attributes.getType().isEmpty()) {
            return false;
        }
        return attributes.getType().equals("sensor");
    }

    public boolean isSwitch() {
        if (attributes.getType() == null || attributes.getType().isEmpty()) {
            return false;
        }
        return attributes.getType().equals("switch");
    }

}
