package com.imgarena.licensing.tennis.model;

import com.imgarena.licensing.tennis.identifiers.CustomerId;

public record TennisMatchLicense(CustomerId customerId, TennisMatch tennisMatch) {
}
