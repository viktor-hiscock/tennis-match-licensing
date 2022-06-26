package com.imgarena.licensing.tennis.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateTennisTournamentLicenseRequestDTO {
    private Long customerId;
    private Long tennisTournamentId;
}
