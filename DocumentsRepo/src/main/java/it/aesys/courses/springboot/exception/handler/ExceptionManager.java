package it.aesys.courses.springboot.exception.handler;

import it.aesys.courses.springboot.exception.AlreadyExistsException;
import it.aesys.courses.springboot.exception.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionManager {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String> handleNotFound(NotFoundException e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler(AlreadyExistsException.class)
    public ResponseEntity<String> handleAlreadyExists(AlreadyExistsException e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }


}