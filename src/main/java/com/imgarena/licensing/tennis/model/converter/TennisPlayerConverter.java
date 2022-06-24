package com.imgarena.licensing.tennis.model.converter;

import com.imgarena.licensing.tennis.identifiers.TennisPlayerId;

import javax.persistence.AttributeConverter;

public class TennisPlayerConverter implements AttributeConverter<TennisPlayerId, String> {
    @Override
    public String convertToDatabaseColumn(TennisPlayerId tennisPlayerId) {
        return tennisPlayerId.identifier();
    }

    @Override
    public TennisPlayerId convertToEntityAttribute(String tennisPlayerId) {
        return new TennisPlayerId(tennisPlayerId);
    }
}
