package com.imgarena.licensing.tennis.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TennisPlayerResponseDTO {
    private final Long tennisPlayerId;
    private final String firstName;
    private final String lastName;
}
