package com.imgarena.licensing.tennis.entity.converter;

import com.imgarena.licensing.tennis.identifiers.CustomerId;

import javax.persistence.AttributeConverter;
import java.util.UUID;

public class CustomerIdConverter implements AttributeConverter<CustomerId, UUID> {
    @Override
    public UUID convertToDatabaseColumn(CustomerId customerId) {
        return customerId.identifier();
    }

    @Override
    public CustomerId convertToEntityAttribute(UUID customerId) {
        return new CustomerId(customerId);
    }
}
