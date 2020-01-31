package org.jorgma.athome.pincode.domain;

/**
 * Created by jorgma on 2018-08-22.
 */
public class ValidPincode {

    private boolean valid;

    public ValidPincode(boolean valid) {
        this.valid = valid;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }
}
