package com.imgarena.licensing.tennis.exception;

public class TennisMatchNotFoundException extends RuntimeException {
    public TennisMatchNotFoundException(Long matchId) {
        super(String.format("Tennis match %s does not exist", matchId));
    }
}
