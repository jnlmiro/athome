package org.jorgma.athome.sl.business;

import org.jorgma.athome.sl.domain.Departure;
import org.jorgma.athome.sl.domain.SlDeparturesRestApiResponse;

import java.util.List;

/**
 * Created by jorgma on 2018-03-17.
 */
public interface SlDeparturesBl {
    List<Departure> getDepartures(int siteId);
}
