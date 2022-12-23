package it.aesys.courses.springboot.personregistry.controller;

import it.aesys.courses.springboot.personregistry.CustomValidators.FiscalCodeValidator;
import it.aesys.courses.springboot.personregistry.models.mapper.ApiErrorDTO;
import it.aesys.courses.springboot.personregistry.models.mapper.ErrorDTO;
import it.aesys.courses.springboot.personregistry.service.exceptions.ServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import java.util.Set;

@ControllerAdvice
public class ErrorManageController {


    @ExceptionHandler(value = ServiceException.class)
    public ResponseEntity<ApiErrorDTO> errorManage(ServiceException ex, WebRequest request) {


        return getErrorMessages(ex, request);
    }
    public ResponseEntity<ApiErrorDTO> getErrorMessages (ServiceException bre, WebRequest request) {

        ApiErrorDTO error = new ApiErrorDTO();
        error.setStatusCode(bre.getStatusCode());
        error.setMessage(bre.getMessage());
        error.setPath(request.getContextPath());

        ResponseEntity<ApiErrorDTO> errorResponse = ResponseEntity.status(HttpStatus.resolve(bre.getStatusCode())).body(error);
        return errorResponse;

    }
    @ExceptionHandler(value = ValidationException.class)
    public ResponseEntity<ApiErrorDTO> handleFiscalCodeException(ValidationException validationException, WebRequest request) {
        System.out.println("Errore: il codice fiscale non ha la lunghezza corretta " + validationException);
        ApiErrorDTO error = new ApiErrorDTO();
        error.setStatusCode(400);
        error.setMessage("Bad Request");
        error.setPath(request.getContextPath());
        ResponseEntity<ApiErrorDTO> errorResponse = ResponseEntity.status(HttpStatus.resolve(error.getStatusCode())).body(error);
        return errorResponse ;
    }
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ApiErrorDTO> handleGenericException(Exception e, WebRequest request) {
        System.out.println("Errore: " + e);
        ApiErrorDTO error = new ApiErrorDTO();
        error.setStatusCode(500);
        error.setMessage("Generic Error");
        error.setPath(request.getContextPath());
        return ResponseEntity.internalServerError().body(error);
    }
}
