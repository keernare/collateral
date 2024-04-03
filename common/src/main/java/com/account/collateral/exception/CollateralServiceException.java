package com.account.collateral.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CollateralServiceException extends RuntimeException {

    public CollateralServiceException(final String message) {
        super(message);
    }

}
