package org.jorgma.athome.sl.service;

import org.jorgma.athome.exceptions.AlreadyExistsException;
import org.jorgma.athome.sl.business.StationBl;
import org.jorgma.athome.sl.domain.Station;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jorgma on 2017-12-10.
 */
@Service
public class StationServiceImpl implements StationService {
    private StationBl stationBl;

    public StationServiceImpl(StationBl stationBl) {
        this.stationBl = stationBl;
    }

    @Override
    public void saveStation(Station station) {
        if(stationBl.exists(station.getSiteId())) {
            throw new AlreadyExistsException("Station already saved");
        }
        stationBl.saveStation(station);
    }

    @Override
    public void updateStation(Station station) {
        stationBl.saveStation(station);
    }

    @Override
    public Station getStation(int id) {
        return stationBl.getStation(id);
    }

    @Override
    public List<Station> getStations() {
        return stationBl.getStations();
    }

    @Override
    public void deleteStation(int id) {
        stationBl.deleteStation(id);
    }

    @Override
    public List<Station> getEnabledStations() {
        return stationBl.getEnabledStations();
    }
}
