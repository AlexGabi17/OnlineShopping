package com.proiectfacultate.proiectfacultate.common.exceptions;

import org.springframework.http.HttpStatus;

public class UserNotLoggedInException extends BaseException{
    public UserNotLoggedInException(String message) {
        super(message, HttpStatus.UNAUTHORIZED);
    }
}
