package com.imgarena.licensing.tennis.exception;

public class TennisMatchNotFoundException extends RuntimeException implements ResourceNotFoundException {
    public TennisMatchNotFoundException(Long tennisMatchId) {
        super(String.format("Tennis match %s does not exist", tennisMatchId));
    }

    @Override
    public String getCode() {
        return BusinessErrorCode.TENNIS_MATCH_NOT_FOUND.getErrorCode();
    }
}
