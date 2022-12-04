package com.quik.model;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NoCorrespondingTradingStrategy extends RuntimeException {
    public NoCorrespondingTradingStrategy(String message) {
        super(message);
    }
}
