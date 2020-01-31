package org.jorgma.athome.weather.business;

import org.jorgma.athome.weather.domain.Weather;
import org.jorgma.athome.weather.domain.Weather;

/**
 * Created by jorgma on 2018-02-20.
 */
public interface WeatherBl {

    Weather getForCoordinates(double latitude, double longitude);
}
