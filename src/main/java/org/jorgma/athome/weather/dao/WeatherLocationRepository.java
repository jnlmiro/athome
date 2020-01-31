package org.jorgma.athome.weather.dao;

import org.jorgma.athome.weather.domain.WeatherLocation;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

/**
 * Created by jorgma on 2018-02-21.
 */
public interface WeatherLocationRepository extends PagingAndSortingRepository<WeatherLocation, Integer> {

    Optional<WeatherLocation> findByCurrent(boolean isCurrent);
}
