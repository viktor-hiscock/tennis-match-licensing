package com.imgarena.licensing.tennis.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TennisMatchResponseDTO {
    private String matchId;
    private StartDateDTO startDate;
    private TennisPlayerResponseDTO tennisPlayerA;
    private TennisPlayerResponseDTO tennisPlayerB;
}
