package org.jorgma.athome.zwave.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Created by jorgma on 2018-08-08.
 */
@Entity(name = "zwave_sensors")
public class ZwaveSensor extends ZwaveComponent {

    @Column(name = "sensor_type")
    private String sensorType;
    @Column(name = "unit_of_measurement")
    private String unitOfMeasurement;
    private boolean alarming;


    public String getSensorType() {
        return sensorType;
    }

    public void setSensorType(String sensorType) {
        this.sensorType = sensorType;
    }

    public String getUnitOfMeasurement() {
        return unitOfMeasurement;
    }

    public void setUnitOfMeasurement(String unitOfMeasurement) {
        this.unitOfMeasurement = unitOfMeasurement;
    }


    public boolean isAlarming() {
        return alarming;
    }

    public void setAlarming(boolean alarming) {
        this.alarming = alarming;
    }
}
