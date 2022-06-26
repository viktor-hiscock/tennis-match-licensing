package com.imgarena.licensing.tennis.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Data
@Builder
public class CreateTennisMatchRequestDTO {
    @Valid
    @NotNull
    private StartDateDTO startDate;

    private Long tennisPlayerAId;

    private Long tennisPlayerBId;
}
