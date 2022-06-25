package com.imgarena.licensing.tennis.exception;

import com.imgarena.licensing.tennis.identifiers.MatchId;

public class TennisMatchNotFoundException extends RuntimeException {
    public TennisMatchNotFoundException(MatchId matchId) {
        super(String.format("Tennis player %s does not exist", matchId.identifier()));
    }
}
