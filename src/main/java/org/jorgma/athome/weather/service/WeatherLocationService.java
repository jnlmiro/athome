package org.jorgma.athome.weather.service;

import org.jorgma.athome.weather.domain.WeatherLocation;

import java.util.List;
import java.util.Optional;

/**
 * Created by jorgma on 2018-02-23.
 */
public interface WeatherLocationService {

    WeatherLocation saveWeatherLocation(WeatherLocation weatherLocation);

    WeatherLocation setCurrentWeatherLocation(WeatherLocation weatherLocation);

    List<WeatherLocation> getAllWeatherLocations();

    List<WeatherLocation> searchWeatherLocation(String place);

    Optional<WeatherLocation> getCurrentWeatherLocation();

    WeatherLocation removeWeatherLocation(int id);
}
