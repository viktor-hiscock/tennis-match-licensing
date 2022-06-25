package com.imgarena.licensing.tennis.model.converter;

import javax.persistence.AttributeConverter;
import java.time.ZoneId;

public class ZoneIdConverter implements AttributeConverter<ZoneId, String> {
    @Override
    public String convertToDatabaseColumn(ZoneId zoneId) {
        return zoneId.toString();
    }

    @Override
    public ZoneId convertToEntityAttribute(String zoneId) {
        return ZoneId.of(zoneId);
    }
}
