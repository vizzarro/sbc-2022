package it.aesys.courses.springboot.lesson1.brandolini.services.exceptions;

public class ServiceExceptionBrandolini extends Exception{

    public ServiceExceptionBrandolini() {
    }

    private int statusCode;


    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }



    public ServiceExceptionBrandolini(String message) {
        super(message);
    }

    public ServiceExceptionBrandolini(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceExceptionBrandolini(Throwable cause) {
        super(cause);
    }

    public ServiceExceptionBrandolini(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
