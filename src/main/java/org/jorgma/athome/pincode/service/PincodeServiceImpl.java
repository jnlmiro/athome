package org.jorgma.athome.pincode.service;

import org.jorgma.athome.exceptions.InvalidPincodeException;
import org.jorgma.athome.pincode.business.PincodeBl;
import org.jorgma.athome.pincode.domain.Pincode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by jorgma on 2018-08-22.
 */
@Service
public class PincodeServiceImpl implements PincodeService {

    @Autowired
    private PincodeBl pincodeBl;

    @Override
    public List<Pincode> getPincodes() {
        return pincodeBl.getPincodes();
    }

    @Override
    public Pincode createPincode(Pincode pincode) {
        return pincodeBl.createPincode(pincode);
    }

    @Override
    public Optional<Pincode> getPincodeByCode(String code) throws InvalidPincodeException {
        return pincodeBl.getPincodeByCode(code);
    }
}
