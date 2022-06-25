package com.imgarena.licensing.tennis.model.converter;

import com.imgarena.licensing.tennis.identifiers.MatchId;

import javax.persistence.AttributeConverter;

public class MatchIdConverter implements AttributeConverter<MatchId, String> {
    @Override
    public String convertToDatabaseColumn(MatchId matchId) {
        return matchId.identifier();
    }

    @Override
    public MatchId convertToEntityAttribute(String matchId) {
        return new MatchId(matchId);
    }
}
