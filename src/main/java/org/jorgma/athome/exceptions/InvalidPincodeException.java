package org.jorgma.athome.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by jorgma on 2018-08-22.
 */
@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class InvalidPincodeException extends RuntimeException {

    public InvalidPincodeException(String message) {
        super(message);
    }
}
