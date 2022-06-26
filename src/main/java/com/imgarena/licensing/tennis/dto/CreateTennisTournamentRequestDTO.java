package com.imgarena.licensing.tennis.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CreateTennisTournamentRequestDTO {
    private List<Long> tennisMatchIds;
    private String placeholder;
}
