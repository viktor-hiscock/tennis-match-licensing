package com.imgarena.licensing.tennis.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.imgarena.licensing.tennis.dto.validation.ZoneId;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StartDateDTO {
    private static final String TIMESTAMP_PATTERN = "yyyy-MM-dd HH:mm";

    @JsonFormat(pattern = TIMESTAMP_PATTERN)
    private String timestamp;
    @ZoneId
    private String zoneId;
}
