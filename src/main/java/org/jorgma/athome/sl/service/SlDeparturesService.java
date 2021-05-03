package org.jorgma.athome.sl.service;

import org.jorgma.athome.sl.domain.Departure;
import org.jorgma.athome.sl.domain.SlDeparturesRestApiResponse;

import java.util.List;

/**
 * Created by jorgma on 2017-12-02.
 */
public interface SlDeparturesService {
    List<Departure> getDepartures(int siteId);
}
