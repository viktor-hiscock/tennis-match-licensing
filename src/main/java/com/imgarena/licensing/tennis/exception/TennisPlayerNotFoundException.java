package com.imgarena.licensing.tennis.exception;

public class TennisPlayerNotFoundException extends RuntimeException {
    public TennisPlayerNotFoundException(Long tennisPlayerId) {
        super(String.format("Tennis player %s does not exist", tennisPlayerId));
    }
}
