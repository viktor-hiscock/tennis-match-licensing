package com.imgarena.licensing.tennis.dto;

import com.imgarena.licensing.tennis.dto.validation.IMGArenaId;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Data
@Builder
public class CreateTennisPlayerRequestDTO {
    @NotBlank
    @IMGArenaId
    private String tennisPlayerId;
    @NotBlank
    @Length(max = 100)
    private String firstName;
    @NotBlank
    @Length(max = 100)
    private String lastName;
}
