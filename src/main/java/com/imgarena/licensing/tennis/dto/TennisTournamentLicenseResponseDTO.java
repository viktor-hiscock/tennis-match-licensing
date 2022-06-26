package com.imgarena.licensing.tennis.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TennisTournamentLicenseResponseDTO {
    private Long tennisTournamentLicenseId;
    private TennisTournamentResponseDTO tennisTournament;
}
