package org.jorgma.athome.rpi.service;

import org.jorgma.athome.rpi.business.RpiBackLightBl;
import org.jorgma.athome.rpi.dao.RpiBackLight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Created by jorgma on 2018-03-24.
 */
@Service
public class RpiBackLightServiceImpl implements RpiBackLightService {

    @Autowired
    private RpiBackLightBl rpiBackLightBl;

    @Override
    public int getBackLightIntensity() {
        return rpiBackLightBl.getBackLightIntensity();
    }

    @Override
    public void setBackLightIntensity(RpiBackLight rpiBackLight) throws IOException {
        rpiBackLightBl.setBackLightIntensity(rpiBackLight);
    }
}
