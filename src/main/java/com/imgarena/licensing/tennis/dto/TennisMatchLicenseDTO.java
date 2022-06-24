package com.imgarena.licensing.tennis.dto;

import lombok.Data;
import lombok.NonNull;

@Data
public class TennisMatchLicenseDTO {
    @NonNull
    private final String customerId;
    @NonNull
    private final String tennisMatchId;
}
