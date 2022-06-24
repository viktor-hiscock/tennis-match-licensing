package com.imgarena.licensing.tennis.entity.converter;

import com.imgarena.licensing.tennis.identifiers.MatchId;

import javax.persistence.AttributeConverter;
import java.util.UUID;

public class MatchIdConverter implements AttributeConverter<MatchId, UUID> {
    @Override
    public UUID convertToDatabaseColumn(MatchId matchId) {
        return matchId.identifier();
    }

    @Override
    public MatchId convertToEntityAttribute(UUID matchId) {
        return new MatchId(matchId);
    }
}
