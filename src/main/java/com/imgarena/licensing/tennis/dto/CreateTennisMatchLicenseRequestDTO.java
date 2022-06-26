package com.imgarena.licensing.tennis.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateTennisMatchLicenseRequestDTO {
    private Long tennisMatchId;
    private String placeHolder;
}
