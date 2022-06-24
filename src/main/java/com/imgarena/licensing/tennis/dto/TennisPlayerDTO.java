package com.imgarena.licensing.tennis.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TennisPlayerDTO {
    private final String tennisPlayerId;
    private final String firstName;
    private final String lastName;
}
