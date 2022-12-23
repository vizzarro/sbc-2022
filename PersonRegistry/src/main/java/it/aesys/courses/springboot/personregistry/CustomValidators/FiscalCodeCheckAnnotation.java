package it.aesys.courses.springboot.personregistry.CustomValidators;



import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;


@Documented
@Constraint(validatedBy = FiscalCodeValidator.class)
@Target({FIELD})
@Retention(RUNTIME)
public @interface FiscalCodeCheckAnnotation {
    String message() default "must be exactly 16 characters";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
