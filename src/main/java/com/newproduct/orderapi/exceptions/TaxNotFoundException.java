package com.newproduct.orderapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class TaxNotFoundException extends RuntimeException{

    public TaxNotFoundException(Long id) {
        super("Tax not found with ID: " + id);
    }
}
