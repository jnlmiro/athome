package org.jorgma.athome.zwave.rest;

import org.jorgma.athome.zwave.domain.ZwaveSensor;
import org.jorgma.athome.zwave.service.ZwaveComponentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by jorgma on 2018-07-08.
 */
@RestController
@RequestMapping("/api/zwave")
public class ZwaveComponentController {

    @Autowired
    private ZwaveComponentService zwaveComponentService;

    @RequestMapping(value = "/ha-sensors", method = RequestMethod.GET)
    public List<ZwaveSensor> getSensorsFromHa() {
        return zwaveComponentService.getSensorsFromHa();
    }

    @RequestMapping(value = "/ha-sensors/{haId:.+}", method = RequestMethod.GET)
    public ZwaveSensor getSensorFromHa(@PathVariable("haId") String haId) {
        return zwaveComponentService.getSensorFromHa(haId);
    }

    @RequestMapping(value = "/sensors", method = RequestMethod.GET)
    public List<ZwaveSensor> saveSensor() {
        return zwaveComponentService.getAllSensors();
    }


    @RequestMapping(value = "/sensors/{id}", method = RequestMethod.GET)
    public ZwaveSensor saveSensor(@PathVariable() int id) {
        return zwaveComponentService.getSensor(id);
    }


    @RequestMapping(value = "/sensors", method = RequestMethod.POST)
    public ZwaveSensor saveSensor(@RequestBody ZwaveSensor zwaveSensor) {
        return zwaveComponentService.saveSensor(zwaveSensor);
    }


    @RequestMapping(value = "/sensors/{id}", method = RequestMethod.DELETE)
    public ZwaveSensor removeSensor(@PathVariable int id) {
        return zwaveComponentService.removeSensor(id);
    }

}
