package com.stiki.pixels.sumapi.exception;

import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    private static final MediaType CONTENT_TYPE = MediaType.APPLICATION_JSON;

    @ExceptionHandler(value = {ValidationException.class})
    public ResponseEntity<ErrorMessage> handleValidationException(ValidationException ex) {
        logException(ex);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .contentType(CONTENT_TYPE)
                .body(new ErrorMessage(ex.getMessage(), HttpStatus.BAD_REQUEST, ex.getErrors()));
    }

    private void logException(@NotNull Exception ex) {
        log.warn("Exception message: {}", ex.getMessage());
        log.debug("Trace: ", ex);
    }
}