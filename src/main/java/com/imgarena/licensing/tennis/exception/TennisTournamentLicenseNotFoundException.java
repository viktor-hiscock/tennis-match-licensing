package com.imgarena.licensing.tennis.exception;

public class TennisTournamentLicenseNotFoundException extends RuntimeException {
    public TennisTournamentLicenseNotFoundException(Long tennisTournamentLicenseId) {
        super(String.format("Tennis tournament license %s does not exist", tennisTournamentLicenseId));
    }
}
