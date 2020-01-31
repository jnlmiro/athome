package org.jorgma.athome.rpi.service;

import org.jorgma.athome.rpi.dao.RpiBackLight;

import java.io.IOException;

/**
 * Created by jorgma on 2018-03-24.
 */
public interface RpiBackLightService {
    int getBackLightIntensity();

    void setBackLightIntensity(RpiBackLight rpiBackLight) throws IOException;
}
