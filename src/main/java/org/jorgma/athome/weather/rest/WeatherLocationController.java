package org.jorgma.athome.weather.rest;

import org.jorgma.athome.weather.domain.WeatherLocation;
import org.jorgma.athome.weather.service.WeatherLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by jorgma on 2018-02-23.
 */

@RestController
@RequestMapping("/api/weather-locations")
public class WeatherLocationController {
    @Autowired
    WeatherLocationService weatherLocationService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public WeatherLocation saveWeatherLocation(@RequestBody WeatherLocation weatherLocation, HttpServletResponse httpServletResponse) {
        httpServletResponse.setStatus(HttpStatus.CREATED.value());
        return weatherLocationService.saveWeatherLocation(weatherLocation);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public WeatherLocation setCurrentWeatherLocation(@RequestBody WeatherLocation weatherLocation) {
        return weatherLocationService.setCurrentWeatherLocation(weatherLocation);
    }

    @RequestMapping(value = "", method = RequestMethod.DELETE)
    public WeatherLocation removeWeatherLocation(@RequestParam("id") int id) {
        return weatherLocationService.removeWeatherLocation(id);
    }

    @RequestMapping(value = "current", method = RequestMethod.GET)
    public WeatherLocation getCurrentWeatherLocation(HttpServletResponse httpServletResponse) {
        if(weatherLocationService.getCurrentWeatherLocation().isPresent()) {
            return weatherLocationService.getCurrentWeatherLocation().get();
        }else {
            httpServletResponse.setStatus(HttpStatus.NO_CONTENT.value());
        }

        return null;
    }


    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<WeatherLocation> getAllWeatherLocations() {
        return weatherLocationService.getAllWeatherLocations();
    }


    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public List<WeatherLocation> searchWeatherLocation(@RequestParam("place") String place) {
        return weatherLocationService.searchWeatherLocation(place);
    }

}
