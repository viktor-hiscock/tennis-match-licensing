package com.imgarena.licensing.tennis.identifiers;

import java.io.Serializable;
import java.util.UUID;

public record TennisPlayerId(UUID identifier) implements Serializable {
}
