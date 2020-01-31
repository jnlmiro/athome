package org.jorgma.athome.weather.service;

import org.jorgma.athome.weather.business.WeatherLocationBl;
import org.jorgma.athome.weather.domain.WeatherLocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by jorgma on 2018-02-23.
 */
@Service
public class WeatherLocationServiceImpl implements WeatherLocationService {

    @Autowired
    WeatherLocationBl weatherLocationBl;


    @Override
    public WeatherLocation saveWeatherLocation(WeatherLocation weatherLocation) {
        return weatherLocationBl.saveWeatherLocation(weatherLocation);
    }

    @Override
    public WeatherLocation setCurrentWeatherLocation(WeatherLocation weatherLocation) {
        return weatherLocationBl.setCurrentWeatherLocation(weatherLocation);
    }

    @Override
    public List<WeatherLocation> getAllWeatherLocations() {
        return weatherLocationBl.getAllWeatherLocations();
    }

    @Override
    public List<WeatherLocation> searchWeatherLocation(String place) {
        return weatherLocationBl.searchWeatherLocation(place);
    }

    @Override
    public Optional<WeatherLocation> getCurrentWeatherLocation() {
        return weatherLocationBl.getCurrentWeatherLocation();
    }

    @Override
    public WeatherLocation removeWeatherLocation(int id) {
        return weatherLocationBl.removeWeatherLocation(id);
    }
}
