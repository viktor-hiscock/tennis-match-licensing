package com.imgarena.licensing.tennis.exception;

public class TennisMatchLicenseNotFoundException extends RuntimeException implements ResourceNotFoundException {
    public TennisMatchLicenseNotFoundException(Long tennisMatchLicenseId) {
        super(String.format("Tennis match license %s does not exist", tennisMatchLicenseId));
    }

    @Override
    public String getCode() {
        return BusinessErrorCode.TENNIS_MATCH_LICENSE_NOT_FOUND.getErrorCode();
    }
}
