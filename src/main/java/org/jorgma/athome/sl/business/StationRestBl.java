package org.jorgma.athome.sl.business;

import org.jorgma.athome.sl.domain.StationTrafikLab;

import java.util.List;

/**
 * Created by jorgma on 2017-12-10.
 */
public interface StationRestBl {
    List<StationTrafikLab> searchStations(String searchParam);
}
