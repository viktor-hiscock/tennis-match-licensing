package com.imgarena.licensing.tennis.exception;

public class TennisMatchNotFoundException extends RuntimeException implements ResourceNotFoundException {
    public TennisMatchNotFoundException(Long matchId) {
        super(String.format("Tennis match %s does not exist", matchId));
    }

    @Override
    public String getCode() {
        return BusinessErrorCode.TENNIS_MATCH_NOT_FOUND.getErrorCode();
    }
}
