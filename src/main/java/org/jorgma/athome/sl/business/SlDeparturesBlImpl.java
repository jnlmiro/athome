package org.jorgma.athome.sl.business;

import org.jorgma.athome.sl.domain.Departure;
import org.jorgma.athome.sl.domain.SlDeparturesRestApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

/**
 * Created by jorgma on 2018-03-17.
 */
@Service
public class SlDeparturesBlImpl implements SlDeparturesBl {

    @Autowired
    RestTemplate trustableSslRestTemplate;

    private final String SL_DEPARTURES_URL = "https://webcloud.sl.se/api/departures?mode=departures&origId=$siteId";

    public SlDeparturesRestApiResponse getDepartureGroups(int siteId) {
        return trustableSslRestTemplate.getForObject(getDepartureUrl(siteId), SlDeparturesRestApiResponse.class);
    }

    @Override
    public List<Departure> getDepartures(int siteId) {
        Departure[] departures = trustableSslRestTemplate.getForObject(getDepartureUrl(siteId), Departure[].class);
        return Arrays.asList(departures);
    }

    private String getDepartureUrl(int siteId) {
        return SL_DEPARTURES_URL.replace("$siteId", String.valueOf(siteId));
    }
}
