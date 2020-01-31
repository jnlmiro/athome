package org.jorgma.athome.sl.rest;

import org.jorgma.athome.sl.domain.Station;
import org.jorgma.athome.sl.domain.StationTrafikLab;
import org.jorgma.athome.sl.service.StationService;
import org.jorgma.athome.sl.service.TrafikLabStationsRestService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by jorgma on 2017-12-10.
 */
@RestController
@RequestMapping("/api/stations")
public class StationController {

    private StationService stationService;
    private TrafikLabStationsRestService trafikLabStationsRestService;

    public StationController(StationService stationService, TrafikLabStationsRestService trafikLabStationsRestService) {
        this.stationService = stationService;
        this.trafikLabStationsRestService = trafikLabStationsRestService;
    }


    @RequestMapping(method = RequestMethod.POST)
    public void saveStation(@RequestBody Station station) {
        stationService.saveStation(station);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void updateStations(@RequestBody Station station) {
        stationService.updateStation(station);
    }




    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Station getStation(@PathVariable int id) {
        return stationService.getStation(id);
    }


    @RequestMapping(method = RequestMethod.GET)
    public List<Station> getStations() {
        return stationService.getStations();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteStation(@PathVariable int id) {
        stationService.deleteStation(id);
    }


    @RequestMapping(value = "enabled", method = RequestMethod.GET)
    public List<Station> getEnabledStations() {
        return stationService.getEnabledStations();
    }

    @RequestMapping(value = "search", method = RequestMethod.GET)
    public List<StationTrafikLab> searchStations(@RequestParam String stationName) {
        return trafikLabStationsRestService.searchStations(stationName);
    }


}
