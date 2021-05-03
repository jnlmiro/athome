package org.jorgma.athome.sl.service;

import org.jorgma.athome.sl.business.SlDeparturesBl;
import org.jorgma.athome.sl.domain.Departure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jorgma on 2017-12-02.
 */
@Service
public class SlDeparturesServiceImpl implements SlDeparturesService {

    @Autowired
    SlDeparturesBl slDeparturesBl;

    @Override
    public List<Departure> getDepartures(int siteId) {
        return slDeparturesBl.getDepartures(siteId);
    }

}
