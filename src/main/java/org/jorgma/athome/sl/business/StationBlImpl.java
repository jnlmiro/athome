package org.jorgma.athome.sl.business;

import org.jorgma.athome.sl.dao.StationsRepository;
import org.jorgma.athome.sl.domain.Station;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by jorgma on 2017-12-10.
 */
@Repository
public class StationBlImpl implements StationBl {
    @Autowired
    private StationsRepository stationsRepository;


    @Override
    public void saveStation(Station station) { stationsRepository.save(station); }

    @Override
    public Station getStation(int id) {
        return stationsRepository.findById(id).get();
    }

    @Override
    public List<Station> getStations() {
        return (List<Station>) stationsRepository.findAll();
    }

    @Override
    public void deleteStation(int id) {
        stationsRepository.deleteById(id);
    }

    @Override
    public List<Station> getEnabledStations() {
        return stationsRepository.findByEnabled(true);
    }

    @Override
    public boolean exists(int id) {
        return stationsRepository.findById(id).isPresent();
    }
}
