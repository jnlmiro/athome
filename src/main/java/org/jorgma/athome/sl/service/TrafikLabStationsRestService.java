package org.jorgma.athome.sl.service;

import org.jorgma.athome.sl.domain.StationTrafikLab;

import java.util.List;

/**
 * Created by jorgma on 2017-12-10.
 */
public interface TrafikLabStationsRestService {

    List<StationTrafikLab> searchStations(String searchParam);
}
