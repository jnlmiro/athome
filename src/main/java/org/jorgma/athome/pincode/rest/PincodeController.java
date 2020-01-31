package org.jorgma.athome.pincode.rest;

import org.jorgma.athome.exceptions.InvalidPincodeException;
import org.jorgma.athome.pincode.domain.Pincode;
import org.jorgma.athome.pincode.service.PincodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * Created by jorgma on 2018-08-22.
 */

@RestController
@RequestMapping("/api/pincodes")
public class PincodeController {

    @Autowired
    private PincodeService pincodeService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Pincode> getPincodes() {
        return pincodeService.getPincodes();
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Pincode createPincode(Pincode pincode) {
        return pincodeService.createPincode(pincode);
    }


    @RequestMapping(value = "/validate", method = RequestMethod.POST)
    public Pincode getPincodeByCode(String code) throws InvalidPincodeException {
        Optional<Pincode> pincode = pincodeService.getPincodeByCode(code);
        if (!pincode.isPresent()) {
            throw new InvalidPincodeException("Please try again");
        }

        return pincode.get();
    }
}
