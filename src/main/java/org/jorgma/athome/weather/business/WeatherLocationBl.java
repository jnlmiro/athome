package org.jorgma.athome.weather.business;

import org.jorgma.athome.weather.domain.WeatherLocation;

import java.util.List;
import java.util.Optional;

/**
 * Created by jorgma on 2018-02-23.
 */
public interface WeatherLocationBl {

    WeatherLocation saveWeatherLocation(WeatherLocation weatherLocation);

    List<WeatherLocation> getAllWeatherLocations();

    List<WeatherLocation> searchWeatherLocation(String place);

    WeatherLocation setCurrentWeatherLocation(WeatherLocation weatherLocation);

    Optional<WeatherLocation> getCurrentWeatherLocation();

    WeatherLocation removeWeatherLocation(int id);
}
