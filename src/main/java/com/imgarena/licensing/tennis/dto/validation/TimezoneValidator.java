package com.imgarena.licensing.tennis.dto.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.ZoneId;

public class TimezoneValidator implements ConstraintValidator<Timezone, String> {
    @Override
    public boolean isValid(String timezone, ConstraintValidatorContext constraintValidatorContext) {
        return timezone == null || ZoneId.getAvailableZoneIds().contains(timezone);
    }
}
