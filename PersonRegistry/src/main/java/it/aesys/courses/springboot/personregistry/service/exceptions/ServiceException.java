package it.aesys.courses.springboot.personregistry.service.exceptions;

import it.aesys.courses.springboot.personregistry.controller.ErrorManageController;
import it.aesys.courses.springboot.personregistry.models.mapper.ErrorDTO;
import java.util.Collection;

public class ServiceException extends Exception {

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
        return this.getPath();
    }

    public Collection<? extends ErrorDTO> getErrors() {
        return this.error;
    }
}
