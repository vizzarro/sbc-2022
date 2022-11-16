package it.aesys.courses.springboot.personregistry.service.exceptions;

import it.aesys.courses.springboot.personregistry.controller.ErrorManageController;
import it.aesys.courses.springboot.personregistry.models.mapper.ErrorDTO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.springframework.web.servlet.function.RequestPredicates.path;

public class ServiceException extends Exception {

    private String path;
    private List<ErrorDTO> errors = new ArrayList<>();
    int statusCode = 0;
    private Collection<? extends ErrorDTO> error;

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public ServiceException() {
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }

    public ServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public List<ErrorDTO> getErrors() {
        return errors;
    }

    public void setErrors(List<ErrorDTO> errors) {
        this.errors = errors;
    }


}
