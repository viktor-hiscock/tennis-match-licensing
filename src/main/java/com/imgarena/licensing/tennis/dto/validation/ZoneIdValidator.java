package com.imgarena.licensing.tennis.dto.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ZoneIdValidator implements ConstraintValidator<ZoneId, String> {
    @Override
    public boolean isValid(String timezone, ConstraintValidatorContext constraintValidatorContext) {
        return timezone == null || java.time.ZoneId.getAvailableZoneIds().contains(timezone);
    }
}
