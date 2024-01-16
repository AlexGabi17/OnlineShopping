package com.proiectfacultate.proiectfacultate.common.exceptions;

import org.springframework.http.HttpStatus;

public class EventNotFoundException extends BaseException{
    public EventNotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}

