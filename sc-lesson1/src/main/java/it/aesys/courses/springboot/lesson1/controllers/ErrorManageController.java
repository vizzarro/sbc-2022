package it.aesys.courses.springboot.lesson1.controllers;


import it.aesys.courses.springboot.lesson1.models.mapperdto.ApiErrorDTO;
import it.aesys.courses.springboot.lesson1.vizzarro.services.exceptions.ServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ErrorManageController {


    @ExceptionHandler(value = ServiceException.class)
    public ResponseEntity<ApiErrorDTO> errorManage(ServiceException ex, WebRequest request) {


        return getErrorMessages(ex);


    }


    public ResponseEntity<ApiErrorDTO> getErrorMessages (ServiceException bre) {


        ApiErrorDTO error = new ApiErrorDTO();
        error.setStatusCode(bre.getStatusCode());
        error.setMessage(bre.getMessage());
        error.setPath(bre.getPath());
        error.getErrors().addAll(bre.getErrors());

        ResponseEntity<ApiErrorDTO> errorResponse = ResponseEntity.status(HttpStatus.resolve(bre.getStatusCode())).body(error);
        return errorResponse;

    }

}
