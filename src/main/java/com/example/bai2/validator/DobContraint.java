package com.example.bai2.validator;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;
import java.util.List;
//@Target : annotation nay duoc apply o dau
@Target({ ElementType.FIELD})
// @Retention : annotation nay xu ly luc nao
@Retention(RetentionPolicy.RUNTIME)

@Constraint(
        validatedBy = {DobValidor.class}
)
public @interface DobContraint {
    String message() default "Invalid Date of Birth.";

    int min();
    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
