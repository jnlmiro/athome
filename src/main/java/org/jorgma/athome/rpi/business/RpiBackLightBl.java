package org.jorgma.athome.rpi.business;

import org.jorgma.athome.rpi.dao.RpiBackLight;

import java.io.IOException;

/**
 * Created by jorgma on 2018-03-24.
 */
public interface RpiBackLightBl {

    int getBackLightIntensity();

    void setBackLightIntensity(RpiBackLight rpiBackLight) throws IOException;
}
