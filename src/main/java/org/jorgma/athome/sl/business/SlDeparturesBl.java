package org.jorgma.athome.sl.business;

import org.jorgma.athome.sl.domain.SlDeparturesRestApiResponse;

/**
 * Created by jorgma on 2018-03-17.
 */
public interface SlDeparturesBl {
    SlDeparturesRestApiResponse getDepartureGroups(int siteId);
}
