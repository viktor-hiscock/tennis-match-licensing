package com.imgarena.licensing.tennis.dto.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class IMGArenaIdValidator implements ConstraintValidator<IMGArenaId, String> {
    private static final Pattern IMG_ARENA_PATTERN = Pattern.compile("^[0-9a-zA-Z_]{1,64}$");

    @Override
    public boolean isValid(String imgArenaId, ConstraintValidatorContext constraintValidatorContext) {
        return imgArenaId == null || IMG_ARENA_PATTERN.matcher(imgArenaId).matches();
    }
}
