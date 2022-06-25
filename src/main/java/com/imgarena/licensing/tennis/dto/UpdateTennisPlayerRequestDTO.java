package com.imgarena.licensing.tennis.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Data
public class UpdateTennisPlayerRequestDTO {
    @NotBlank
    @Length(max = 100)
    private String firstName;

    @NotBlank
    @Length(max = 100)
    private String lastName;
}
