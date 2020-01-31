package org.jorgma.athome.zwave.service;

import org.jorgma.athome.zwave.domain.ZwaveHaComponent;
import org.jorgma.athome.zwave.domain.ZwaveSensor;

import java.util.List;

/**
 * Created by jorgma on 2018-08-02.
 */
public interface ZwaveComponentService {
    List<ZwaveSensor> getSensorsFromHa();

    ZwaveSensor getSensorFromHa(String haId);

    List<ZwaveHaComponent> getHaComponents();

    ZwaveSensor saveSensor(ZwaveSensor zwaveSensor);

    List<ZwaveSensor> getAllSensors();

    ZwaveSensor getSensor(int id);

    ZwaveSensor removeSensor(int id);
}
