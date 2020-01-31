package org.jorgma.athome.zwave.business;

import org.jorgma.athome.zwave.domain.ZwaveComponent;
import org.jorgma.athome.zwave.domain.ZwaveHaComponent;
import org.jorgma.athome.zwave.domain.ZwaveSensor;

import java.util.List;

/**
 * Created by jorgma on 2018-08-02.
 */
public interface ZwaveComponentBl {

    List<ZwaveSensor> getSensorsFromHa();

    List<ZwaveHaComponent> getHaComponents();

    ZwaveComponent toZwaveSensor(ZwaveHaComponent zwaveHaComponent);

    ZwaveSensor getSensorFromHa(String haId);

    ZwaveSensor saveSensor(ZwaveSensor zwaveSensor);

    List<ZwaveSensor> getAllSensors();

    ZwaveSensor getSensor(int id);

    ZwaveSensor removeSensor(int id);
}
