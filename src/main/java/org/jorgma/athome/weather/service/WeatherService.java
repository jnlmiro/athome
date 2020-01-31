package org.jorgma.athome.weather.service;

import org.jorgma.athome.weather.domain.Weather;

/**
 * Created by jorgma on 2018-02-20.
 */
public interface WeatherService {
    Weather getForCoordinates(double latitude, double longitude);

}
