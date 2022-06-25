package com.imgarena.licensing.tennis.dto;

import com.imgarena.licensing.tennis.dto.validation.IMGArenaId;
import lombok.Builder;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Data
@Builder
public class UpdateTennisMatchRequestDTO {
    @Valid
    @NotNull
    private StartDateDTO startDate;

    @IMGArenaId
    private String tennisPlayerAId;

    @IMGArenaId
    private String tennisPlayerBId;
}
