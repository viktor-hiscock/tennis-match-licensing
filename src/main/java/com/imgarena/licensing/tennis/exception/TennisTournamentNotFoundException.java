package com.imgarena.licensing.tennis.exception;

public class TennisTournamentNotFoundException extends RuntimeException implements ResourceNotFoundException {
    public TennisTournamentNotFoundException(Long tennisTournamentId) {
        super(String.format("Tennis tournament %s does not exist", tennisTournamentId));
    }

    @Override
    public String getCode() {
        return BusinessErrorCode.TENNIS_TOURNAMENT_NOT_FOUND.getErrorCode();
    }
}
