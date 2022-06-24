package com.imgarena.licensing.tennis.model;

import com.imgarena.licensing.tennis.identifiers.CustomerId;

import java.util.Collection;

public record TennisTournamentLicense(CustomerId customerId, Collection<TennisMatch> tennisMatches) {
}
