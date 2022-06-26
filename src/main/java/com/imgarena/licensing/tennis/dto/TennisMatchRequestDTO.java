package com.imgarena.licensing.tennis.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Data
@Builder
public class TennisMatchRequestDTO {
    @Valid
    @NotNull
    private StartDateDTO startDate;

    @NotNull
    private Long tennisPlayerAId;

    @NotNull
    private Long tennisPlayerBId;
}
