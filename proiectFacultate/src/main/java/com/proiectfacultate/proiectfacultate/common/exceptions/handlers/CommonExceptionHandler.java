package com.proiectfacultate.proiectfacultate.common.exceptions.handlers;

import com.proiectfacultate.proiectfacultate.common.exceptions.DatabaseError;
import com.proiectfacultate.proiectfacultate.common.exceptions.EventNotFoundException;
import com.proiectfacultate.proiectfacultate.common.exceptions.UnauthorizedUserException;
import com.proiectfacultate.proiectfacultate.common.exceptions.UserNotLoggedInException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

public class CommonExceptionHandler extends BaseExceptionHandler{
    @ExceptionHandler(DatabaseError.class)
    public ResponseEntity<Object> handleDatabaseError(DatabaseError ex, WebRequest request) {
        return buildResponse(ex, request);
    }

    @ExceptionHandler(EventNotFoundException.class)
    public ResponseEntity<Object> handleEventNotFound(EventNotFoundException ex, WebRequest request) {
        return buildResponse(ex, request);
    }

    @ExceptionHandler(UnauthorizedUserException.class)
    public ResponseEntity<Object> handleUnauthorizedUser(UnauthorizedUserException ex, WebRequest request) {
        return buildResponse(ex, request);
    }

    @ExceptionHandler(UserNotLoggedInException.class)
    public ResponseEntity<Object> handleUserNotLoggedIn(EventNotFoundException ex, WebRequest request) {
        return buildResponse(ex, request);
    }
}
