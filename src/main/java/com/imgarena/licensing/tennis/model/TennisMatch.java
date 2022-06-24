package com.imgarena.licensing.tennis.model;

import com.imgarena.licensing.tennis.identifiers.MatchId;

import java.time.ZonedDateTime;

public record TennisMatch(MatchId matchId, ZonedDateTime startDate, TennisPlayer playerA, TennisPlayer playerB) {
}
