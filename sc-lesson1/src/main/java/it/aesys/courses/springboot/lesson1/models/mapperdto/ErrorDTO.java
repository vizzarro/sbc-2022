package it.aesys.courses.springboot.lesson1.models.mapperdto;

public class ErrorDTO {

    private String field;
    private String message;

    public ErrorDTO() {
        super();
    }

    public ErrorDTO(String field, String message) {
        this.field = field;
        this.message = message;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
