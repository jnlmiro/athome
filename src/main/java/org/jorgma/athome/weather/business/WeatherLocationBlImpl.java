package org.jorgma.athome.weather.business;

import org.jorgma.athome.weather.dao.WeatherLocationRepository;
import org.jorgma.athome.weather.domain.WeatherLocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by jorgma on 2018-02-23.
 */
@Service
public class WeatherLocationBlImpl implements WeatherLocationBl {

    @Autowired
    WeatherLocationRepository weatherLocationRepository;
    @Autowired
    RestTemplate trustableSslRestTemplate;

    @Override
    public WeatherLocation saveWeatherLocation(WeatherLocation weatherLocation) {

        long count = weatherLocationRepository.count();
        if (count == 0) {
            weatherLocation.setCurrent(true);
        }

        return weatherLocationRepository.save(weatherLocation);
    }

    @Override
    public List<WeatherLocation> getAllWeatherLocations() {
        return (List<WeatherLocation>) weatherLocationRepository.findAll();
    }

    @Override
    public WeatherLocation setCurrentWeatherLocation(WeatherLocation weatherLocation) {
        Optional<WeatherLocation> currentWeatherLocation = this.getCurrentWeatherLocation();
        if (currentWeatherLocation.isPresent()) {
            currentWeatherLocation.get().setCurrent(false);
            weatherLocationRepository.save(currentWeatherLocation.get());
        }

        weatherLocation.setCurrent(true);
        return weatherLocationRepository.save(weatherLocation);
    }


    @Override
    public Optional<WeatherLocation> getCurrentWeatherLocation() {
        return weatherLocationRepository.findByCurrent(true);
    }

    @Override
    public List<WeatherLocation> searchWeatherLocation(String place) {
        if (place.isEmpty()) {
            return new ArrayList<>();
        }

        String url = "https://www.smhi.se/wpt-a/backend_solr/autocomplete/search/$place";
        ResponseEntity<List<WeatherLocation>> responseEntity = trustableSslRestTemplate.exchange(url.replace("$place", place), HttpMethod.GET, null, new ParameterizedTypeReference<List<WeatherLocation>>() {
        });
        List<WeatherLocation> weatherLocations = responseEntity.getBody();
        return weatherLocations;
    }

    @Override
    public WeatherLocation removeWeatherLocation(int id) {
        Optional<WeatherLocation> weatherLocation = weatherLocationRepository.findById(id);
        weatherLocationRepository.deleteById(id);
        return weatherLocation.get();
    }
}
