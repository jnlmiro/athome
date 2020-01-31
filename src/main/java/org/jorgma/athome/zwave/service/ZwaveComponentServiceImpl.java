package org.jorgma.athome.zwave.service;

import org.jorgma.athome.zwave.business.ZwaveComponentBl;
import org.jorgma.athome.zwave.domain.ZwaveHaComponent;
import org.jorgma.athome.zwave.domain.ZwaveSensor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jorgma on 2018-08-02.
 */
@Service
public class ZwaveComponentServiceImpl implements ZwaveComponentService {

    @Autowired
    ZwaveComponentBl zwaveComponentBl;

    @Override
    public List<ZwaveSensor> getSensorsFromHa() {
        return zwaveComponentBl.getSensorsFromHa();
    }

    @Override
    public ZwaveSensor getSensorFromHa(String haId) {
        return zwaveComponentBl.getSensorFromHa(haId);
    }

    @Override
    public List<ZwaveHaComponent> getHaComponents() {
        return null;
    }

    @Override
    public ZwaveSensor saveSensor(ZwaveSensor zwaveSensor) {
        return zwaveComponentBl.saveSensor(zwaveSensor);
    }

    @Override
    public List<ZwaveSensor> getAllSensors() {
        return zwaveComponentBl.getAllSensors();
    }

    @Override
    public ZwaveSensor getSensor(int id) {
        return zwaveComponentBl.getSensor(id);
    }

    @Override
    public ZwaveSensor removeSensor(int id) { return zwaveComponentBl.removeSensor(id); }
}
