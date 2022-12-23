package it.aesys.courses.springboot.personregistry.CustomValidators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.annotation.Annotation;

public class FiscalCodeValidator implements ConstraintValidator<FiscalCodeCheckAnnotation, String> {


    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return s.length() == 16;
    }
}
