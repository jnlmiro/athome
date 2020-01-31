package org.jorgma.athome.sl.business;

import org.jorgma.athome.sl.domain.SlDeparturesRestApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by jorgma on 2018-03-17.
 */
@Service
public class SlDeparturesBlImpl implements SlDeparturesBl {

    @Autowired
    RestTemplate trustableSslRestTemplate;

    private final String SL_DEPARTURES_URL = "https://sl.se/api/sv/RealTime/GetDepartures/$siteId";

    public SlDeparturesRestApiResponse getDepartureGroups(int siteId) {
        return trustableSslRestTemplate.getForObject(getDepartureUrl(siteId), SlDeparturesRestApiResponse.class);
    }

    private String getDepartureUrl(int siteId) {
        return SL_DEPARTURES_URL.replace("$siteId", String.valueOf(siteId));
    }
}
