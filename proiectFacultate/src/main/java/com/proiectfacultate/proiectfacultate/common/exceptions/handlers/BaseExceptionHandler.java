package com.proiectfacultate.proiectfacultate.common.exceptions.handlers;

import com.proiectfacultate.proiectfacultate.common.exceptions.BaseException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.Map;

public abstract class BaseExceptionHandler {
    protected ResponseEntity<Object> buildResponse(BaseException ex, WebRequest request){
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now().format(DateTimeFormatter.ISO_INSTANT));
        body.put("status", ex.getStatus().value());
        body.put("error", ex.getStatus().getReasonPhrase());
        body.put("message", ex.getMessage());
        body.put("path", request.getDescription(false).replace("uri=", ""));

        return ResponseEntity.status(ex.getStatus()).body(body);

    }
}
