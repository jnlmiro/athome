package org.jorgma.athome.sl.business;

import org.jorgma.athome.sl.domain.StationTrafikLab;
import org.jorgma.athome.sl.domain.StationsRestApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jorgma on 2017-12-10.
 */
@Service
public class StationRestBlImpl implements StationRestBl {


    @Autowired
    private RestTemplate trustableSslRestTemplate;
    private String uriTemplate = "http://api.sl.se/api2/typeahead.json?key={key}&searchstring={searchstring}";

    @Value("${trafiklab.api.key}")
    private String apiKey;


    @Override
    public List<StationTrafikLab> searchStations(String searchParam) {
        URI uri = buildUri(searchParam);
        return trustableSslRestTemplate.getForObject(uri, StationsRestApiResponse.class).getResponseData();
    }


    private URI buildUri(String searchParam) {
        Map<String, String> params = new HashMap<>();
        params.put("key", apiKey);
        params.put("searchstring", searchParam);
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(this.uriTemplate);
        return builder.buildAndExpand(params).toUri();

    }
}
