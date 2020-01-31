package org.jorgma.athome.sl.service;

import org.jorgma.athome.sl.business.SlDeparturesBl;
import org.jorgma.athome.sl.domain.SlDeparturesRestApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by jorgma on 2017-12-02.
 */
@Service
public class SlDeparturesServiceImpl implements SlDeparturesService {

    @Autowired
    SlDeparturesBl slDeparturesBl;

    @Override
    public SlDeparturesRestApiResponse getDepartureGroups(int siteId) {
        return slDeparturesBl.getDepartureGroups(siteId);
    }
}

