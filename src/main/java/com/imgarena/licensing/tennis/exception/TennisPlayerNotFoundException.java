package com.imgarena.licensing.tennis.exception;

public class TennisPlayerNotFoundException extends RuntimeException implements ResourceNotFoundException {
    public TennisPlayerNotFoundException(Long tennisPlayerId) {
        super(String.format("Tennis player %s does not exist", tennisPlayerId));
    }

    @Override
    public String getCode() {
        return BusinessErrorCode.TENNIS_PLAYER_NOT_FOUND.getErrorCode();
    }
}
