package it.aesys.courses.springboot.lesson1.vizzarro.services.exceptions;

import it.aesys.courses.springboot.lesson1.models.mapperdto.ErrorDTO;

import java.util.ArrayList;
import java.util.List;

public class ServiceException extends Exception{

    private int statusCode;
    private String path;
    private List<ErrorDTO> errors = new ArrayList<>();

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
