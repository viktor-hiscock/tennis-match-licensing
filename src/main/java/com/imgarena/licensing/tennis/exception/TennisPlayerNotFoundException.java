package com.imgarena.licensing.tennis.exception;

import com.imgarena.licensing.tennis.identifiers.TennisPlayerId;

public class TennisPlayerNotFoundException extends RuntimeException {
    public TennisPlayerNotFoundException(TennisPlayerId tennisPlayerId) {
        super(String.format("Tennis player %s does not exist", tennisPlayerId.identifier()));
    }
}
