package com.imgarena.licensing.tennis.dto;

import com.imgarena.licensing.tennis.dto.validation.IMGArenaId;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;

@Data
@EqualsAndHashCode(callSuper = true)
@Builder
public class CreateTennisPlayerRequestDTO extends UpdateTennisPlayerRequestDTO {
    @NotBlank
    @IMGArenaId
    private String tennisPlayerId;
}
