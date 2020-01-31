package org.jorgma.athome.sl.service;

import org.jorgma.athome.sl.domain.SlDeparturesRestApiResponse;

/**
 * Created by jorgma on 2017-12-02.
 */
public interface SlDeparturesService {
    SlDeparturesRestApiResponse getDepartureGroups(int siteId);
}
