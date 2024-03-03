package com.stupidstick.intervals.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NO_CONTENT)
public class MinimumIntervalNotFoundException extends RuntimeException {
    public MinimumIntervalNotFoundException() {
        super();
    }

    public MinimumIntervalNotFoundException(String message) {
        super(message);
    }
}
