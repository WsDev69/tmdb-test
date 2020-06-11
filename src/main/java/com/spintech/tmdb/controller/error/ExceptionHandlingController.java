package com.spintech.tmdb.controller.error;

import com.spintech.tmdb.dto.controller.error.ErrorInfo;
import lombok.extern.log4j.Log4j2;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;

@Log4j2
@ControllerAdvice
public class ExceptionHandlingController {

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseBody
    ResponseEntity<ErrorInfo> handleControllerException(HttpServletRequest request, Throwable ex) {
        log.debug("Caught violation exception {}, by url {}", ex.getMessage(), request.getRequestURL());
        return getError(ex.getMessage(), request.getRequestURI(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({EmptyResultDataAccessException.class, DataIntegrityViolationException.class})
    @ResponseBody
    ResponseEntity<ErrorInfo> handleControllerEmptyException(HttpServletRequest request, Throwable ex) {
        log.debug("Caught exception {}, by url {}", ex.getMessage(), request.getRequestURL());
        return getError(ex.getMessage(), request.getRequestURI(), HttpStatus.NOT_FOUND);
    }

    private ResponseEntity<ErrorInfo> getError(String message, String uri, HttpStatus httpStatus) {
        return ResponseEntity.badRequest().body(ErrorInfo
                .builder()
                .error(message)
                .path(uri)
                .message(httpStatus.getReasonPhrase())
                .status(httpStatus.value())
                .build());
    }
}
