package org.jorgma.athome.sl.business;

import org.jorgma.athome.sl.domain.Station;

import java.util.List;

/**
 * Created by jorgma on 2017-12-10.
 */

public interface StationBl {

    void saveStation(Station station);

    Station getStation(int id);

    List<Station> getStations();

    void deleteStation(int id);

    List<Station> getEnabledStations();

    boolean exists(int id);
}
