package com.imgarena.licensing.tennis.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CustomerResponseDTO {
    private List<TennisMatchResponseDTO> tennisMatches;
}
