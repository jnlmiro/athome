package org.jorgma.athome.sl.service;

import org.jorgma.athome.sl.domain.Station;

import java.util.List;

/**
 * Created by jorgma on 2017-12-10.
 */
public interface StationService {

    void saveStation(Station station);

    void updateStation(Station station);

    Station getStation(int id);

    List<Station> getStations();

    void deleteStation(int id);

    List<Station> getEnabledStations();
}
