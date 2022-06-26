package com.imgarena.licensing.tennis.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TennisMatchResponseDTO {
    private Long tennisMatchId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String summary;
    private StartDateDTO startDate;
    private TennisPlayerResponseDTO tennisPlayerA;
    private TennisPlayerResponseDTO tennisPlayerB;
}
