package it.aesys.courses.springboot.lesson1.brandolini.components.exceptions;

public class ComponentExceptionBrandolini extends Exception{

    public ComponentExceptionBrandolini() {
    }

    private int statusCode;

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }


    public ComponentExceptionBrandolini(String message) {
        super(message);
    }

    public ComponentExceptionBrandolini(String message, Throwable cause) {
        super(message, cause);
    }

    public ComponentExceptionBrandolini(Throwable cause) {
        super(cause);
    }

    public ComponentExceptionBrandolini(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
