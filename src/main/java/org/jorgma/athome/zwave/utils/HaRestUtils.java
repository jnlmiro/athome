package org.jorgma.athome.zwave.utils;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

/**
 * Created by jorgma on 2018-08-27.
 */
public class HaRestUtils {


    public static HttpEntity buildHttpEntity(String payload, HttpHeaders headers) {
        headers.set("Content-Type", "application/json");
        HttpEntity<String> entity = new HttpEntity<>(payload, headers);
        return entity;
    }

    public static HttpEntity buildHttpEntity(HttpHeaders headers) {
        HttpEntity<String> entity = new HttpEntity<>(headers);
        return entity;
    }

    public static HttpHeaders buildHttpHeaders(String haApiBeaterToken) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(haApiBeaterToken);
        return headers;
    }

}
