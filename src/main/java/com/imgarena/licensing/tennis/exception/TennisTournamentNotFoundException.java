package com.imgarena.licensing.tennis.exception;

public class TennisTournamentNotFoundException extends RuntimeException {
    public TennisTournamentNotFoundException(Long tennisTournamentId) {
        super(String.format("Tennis tournament %s does not exist", tennisTournamentId));
    }
}
