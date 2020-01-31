package org.jorgma.athome.weather.service;

import org.jorgma.athome.weather.business.WeatherBl;
import org.jorgma.athome.weather.domain.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by jorgma on 2018-02-20.
 */
@Service
public class WeatherServiceImpl implements WeatherService {
    @Autowired
    private WeatherBl weatherBl;

    @Override
    public Weather getForCoordinates(double latitude, double longitude) {
        return weatherBl.getForCoordinates(latitude, longitude);
    }
}
