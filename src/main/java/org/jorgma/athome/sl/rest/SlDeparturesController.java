package org.jorgma.athome.sl.rest;

import org.jorgma.athome.sl.domain.SlDeparturesRestApiResponse;
import org.jorgma.athome.sl.service.SlDeparturesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jorgma on 2017-12-02.
 */
@RestController
@RequestMapping("/api/sl")
public class SlDeparturesController {

    @Autowired
    SlDeparturesService slDeparturesService;

    @RequestMapping(value = "/station/{siteId}", method = RequestMethod.GET)
    public SlDeparturesRestApiResponse getDepartureGroups(@PathVariable int siteId) {
        return slDeparturesService.getDepartureGroups(siteId);
    }
}
