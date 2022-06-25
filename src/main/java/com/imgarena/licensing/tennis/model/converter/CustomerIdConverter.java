package com.imgarena.licensing.tennis.model.converter;

import com.imgarena.licensing.tennis.identifiers.CustomerId;

import javax.persistence.AttributeConverter;
import java.util.UUID;

public class CustomerIdConverter implements AttributeConverter<CustomerId, String> {
    @Override
    public String convertToDatabaseColumn(CustomerId customerId) {
        return customerId.identifier();
    }

    @Override
    public CustomerId convertToEntityAttribute(String customerId) {
        return new CustomerId(customerId);
    }
}
