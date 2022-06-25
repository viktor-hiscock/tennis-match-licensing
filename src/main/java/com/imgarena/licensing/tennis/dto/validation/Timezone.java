package com.imgarena.licensing.tennis.dto.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = {TimezoneValidator.class})
public @interface Timezone {
    String message() default "Not a valid timezone";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
