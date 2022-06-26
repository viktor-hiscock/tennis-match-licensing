package com.imgarena.licensing.tennis.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Builder
public class CreateTennisTournamentRequestDTO {
    @NotNull
    private List<Long> tennisMatchIds;

    @NotBlank
    private String tournamentName;
}
