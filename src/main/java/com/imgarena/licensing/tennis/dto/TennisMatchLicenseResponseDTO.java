package com.imgarena.licensing.tennis.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TennisMatchLicenseResponseDTO {
    private Long tennisMatchLicenseId;
    private TennisMatchResponseDTO tennisMatch;
}
