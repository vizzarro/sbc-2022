package it.aesys.courses.springboot.exception.handler;

import it.aesys.courses.springboot.exception.AlreadyExistsException;
import it.aesys.courses.springboot.exception.InvalidInputException;
import it.aesys.courses.springboot.exception.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionManager {

    @ExceptionHandler({NotFoundException.class, AlreadyExistsException.class, InvalidInputException.class })
    public ResponseEntity<String> handleBadRequest(Exception e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }

//    @ExceptionHandler(AlreadyExistsException.class)
//    public ResponseEntity<String> handleAlreadyExists(AlreadyExistsException e){
//        return ResponseEntity.badRequest().body(e.getMessage());
//    }
//
//    @ExceptionHandler(InvalidInputException.class)
//    public ResponseEntity<String> handleInvalidInput(InvalidInputException e){
//        return ResponseEntity.badRequest().body(e.getMessage());
//    }


}
