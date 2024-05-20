package dev.prateek.productservice.exceptions;

import dev.prateek.productservice.dtos.ExceptionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/*
This if for handling exceptions that occur in multiple controllers
 */

@ControllerAdvice
public class ControllerAdvices {
    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    private ResponseEntity<ExceptionDTO>handleArrayIndexOutOfBoundException(
            ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException
    ){
        return new ResponseEntity<>(new ExceptionDTO(HttpStatus.FAILED_DEPENDENCY, arrayIndexOutOfBoundsException.getMessage()), HttpStatus.FAILED_DEPENDENCY);
    }
}
