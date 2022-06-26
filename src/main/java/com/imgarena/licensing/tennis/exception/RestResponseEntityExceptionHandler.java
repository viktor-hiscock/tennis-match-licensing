package com.imgarena.licensing.tennis.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = {
            CustomerNotFoundException.class,
            TennisPlayerNotFoundException.class,
            TennisMatchNotFoundException.class,
            TennisTournamentNotFoundException.class,
            TennisMatchLicenseNotFoundException.class,
            TennisTournamentLicenseNotFoundException.class
    })
    public ResponseEntity<Object> handleNotFoundException(RuntimeException ex, WebRequest request) {
        ResourceNotFoundException tennisPlayerException = (ResourceNotFoundException) ex;
        ErrorResponse errorResponse = ErrorResponse.builder()
                .message(tennisPlayerException.getMessage())
                .code(tennisPlayerException.getCode())
                .build();
        return handleExceptionInternal(ex, errorResponse, new HttpHeaders(), HttpStatus.CONFLICT, request);
    }
}
