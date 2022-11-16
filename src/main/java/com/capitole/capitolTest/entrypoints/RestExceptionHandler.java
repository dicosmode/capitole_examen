package com.capitole.capitolTest.entrypoints;

import com.capitole.capitolTest.core.entities.dtos.ErrorDTO;
import com.capitole.capitolTest.entrypoints.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler({ NotFoundException.class })
    public ResponseEntity<ErrorDTO> notFoundExceptionHandler(NotFoundException ex) {
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
