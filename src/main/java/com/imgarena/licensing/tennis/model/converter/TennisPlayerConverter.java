package com.imgarena.licensing.tennis.model.converter;

import com.imgarena.licensing.tennis.identifiers.TennisPlayerId;

import javax.persistence.AttributeConverter;
import java.util.UUID;

public class TennisPlayerConverter implements AttributeConverter<TennisPlayerId, UUID> {
    @Override
    public UUID convertToDatabaseColumn(TennisPlayerId tennisPlayerId) {
        return tennisPlayerId.identifier();
    }

    @Override
    public TennisPlayerId convertToEntityAttribute(UUID tennisPlayerId) {
        return new TennisPlayerId(tennisPlayerId);
    }
}
