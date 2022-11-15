package it.aesys.courses.springboot.personregistry.repository.exception;

public class ComponentException extends Exception {

    int statusCode = 0;

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public ComponentException() {
    }

    public ComponentException(String message) {
        super(message);
    }

    public ComponentException(String message, Throwable cause) {
        super(message, cause);
    }

    public ComponentException(Throwable cause) {
        super(cause);
    }

    public ComponentException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
