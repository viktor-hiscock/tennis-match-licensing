package com.imgarena.licensing.tennis.exception;

public class TennisMatchLicenseNotFoundException extends RuntimeException {
    public TennisMatchLicenseNotFoundException(Long tennisMatchLicenseId) {
        super(String.format("Tennis match license %s does not exist", tennisMatchLicenseId));
    }
}
