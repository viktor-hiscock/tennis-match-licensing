package com.imgarena.licensing.tennis.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Builder
public class CustomerRequestDTO {
    private static final String DATE_PATTERN = "yyyy-MM-dd";

    @NotBlank
    @Length(max = 100)
    private String firstName;

    @NotBlank
    @Length(max = 100)
    private String lastName;

    @NotNull
    @JsonFormat(pattern = DATE_PATTERN)
    private String dateOfBirth;

    private List<Long> tennisMatchLicenseIds;

    private List<Long> tennisTournamentLicenseIds;
}
