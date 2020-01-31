package org.jorgma.athome.rpi.rest;

import org.jorgma.athome.rpi.dao.RpiBackLight;
import org.jorgma.athome.rpi.service.RpiBackLightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * Created by jorgma on 2018-03-24.
 */
@RestController
@RequestMapping("/api/rpi-backlight")
public class RpiBackLightController {

    @Autowired
    private RpiBackLightService rpiBackLigService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public int getBackLightIntensity() {
        return rpiBackLigService.getBackLightIntensity();
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public RpiBackLight setBackLightIntensity(@RequestBody RpiBackLight rpiBackLight) throws IOException {
        rpiBackLigService.setBackLightIntensity(rpiBackLight);
        return rpiBackLight;
    }
}
