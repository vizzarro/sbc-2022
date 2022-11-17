package it.aesys.courses.springboot.exception.handler;

import it.aesys.courses.springboot.exception.BadInputException;
import it.aesys.courses.springboot.model.mapperDTO.ErrorResponse;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ExceptionManager {

    @ExceptionHandler ({BadInputException.class, TypeMismatchException.class})
    public ResponseEntity<ErrorResponse> handleBadRequest(Exception e){
        ErrorResponse response = new ErrorResponse();
        response.setError("Bad Input");
        response.setStatus(400);
        response.setMessage(e.getMessage());
        response.setTime(LocalDateTime.now());
        return ResponseEntity.badRequest().body(response);
    }
}
