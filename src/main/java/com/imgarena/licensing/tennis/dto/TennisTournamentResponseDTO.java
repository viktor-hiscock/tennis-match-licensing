package com.imgarena.licensing.tennis.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class TennisTournamentResponseDTO {
    private Long tennisTournamentId;
    private List<TennisMatchResponseDTO> tennisMatches;
}
