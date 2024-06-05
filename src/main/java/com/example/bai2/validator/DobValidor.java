package com.example.bai2.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class DobValidor implements ConstraintValidator<DobContraint, LocalDate>{
    private  int min;
    @Override
    public void initialize(DobContraint constraintAnnotation) {

        ConstraintValidator.super.initialize(constraintAnnotation);
        min = constraintAnnotation.min();
    }

    @Override
    public boolean isValid(LocalDate localDate, ConstraintValidatorContext constraintValidatorContext) {
        if(Objects.isNull(localDate)){
            return true;
        }
        long years = ChronoUnit.YEARS.between(localDate, LocalDate.now());

        return years >= min;
    }
}
