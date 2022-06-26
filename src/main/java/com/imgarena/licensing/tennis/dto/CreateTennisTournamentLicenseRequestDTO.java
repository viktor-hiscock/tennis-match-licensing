package com.imgarena.licensing.tennis.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@Builder
public class CreateTennisTournamentLicenseRequestDTO {
    @NotNull
    private Long tennisTournamentId;

    @NotNull
    private String paymentToken; // TODO: Process license payment
}
