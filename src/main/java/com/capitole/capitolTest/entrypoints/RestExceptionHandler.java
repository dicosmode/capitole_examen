package com.capitole.capitolTest.entrypoints;

import com.capitole.capitolTest.core.entities.dtos.ErrorDTO;
import com.capitole.capitolTest.core.exception.PricesNotFoundException;
import com.capitole.capitolTest.entrypoints.exception.MandatoryException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler({ PricesNotFoundException.class })
    public ResponseEntity<ErrorDTO> notFoundExceptionHandler(PricesNotFoundException ex) {
        ErrorDTO errorDTO = ErrorDTO.builder()
                .errorCode(HttpStatus.NO_CONTENT.value())
                .message(ex.getMessage())
                .build();

        return new ResponseEntity<>(errorDTO, HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler({ MandatoryException.class })
    public ResponseEntity<ErrorDTO> mandatoryExceptionHandler(MandatoryException ex) {
        ErrorDTO errorDTO = ErrorDTO.builder()
                .errorCode(HttpStatus.BAD_REQUEST.value())
                .message(ex.getMessage())
                .build();

        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({ Exception.class })
    public ResponseEntity<ErrorDTO> genericException(Exception ex) {
        ErrorDTO errorDTO = ErrorDTO.builder()
                .errorCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .message(ex.getMessage())
                .build();

        return new ResponseEntity<>(errorDTO, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
