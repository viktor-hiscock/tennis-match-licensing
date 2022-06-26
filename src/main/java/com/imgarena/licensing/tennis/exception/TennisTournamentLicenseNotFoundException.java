package com.imgarena.licensing.tennis.exception;

public class TennisTournamentLicenseNotFoundException extends RuntimeException implements ResourceNotFoundException {
    public TennisTournamentLicenseNotFoundException(Long tennisTournamentLicenseId) {
        super(String.format("Tennis tournament license %s does not exist", tennisTournamentLicenseId));
    }

    @Override
    public String getCode() {
        return BusinessErrorCode.TENNIS_TOURNAMENT_LICENSE_NOT_FOUND.getErrorCode();
    }
}
