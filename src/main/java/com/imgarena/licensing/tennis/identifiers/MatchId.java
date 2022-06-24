package com.imgarena.licensing.tennis.identifiers;

import java.io.Serializable;
import java.util.UUID;

public record MatchId(UUID identifier) implements Serializable {
}
