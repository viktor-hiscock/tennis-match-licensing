package com.imgarena.licensing.tennis.dto.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD, PARAMETER})
@Retention(RUNTIME)
@Constraint(validatedBy = {IMGArenaIdValidator.class})
public @interface IMGArenaId {
    String message() default "Not a valid imgarena id";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
