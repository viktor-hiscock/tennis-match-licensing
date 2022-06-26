package com.imgarena.licensing.tennis.mapper;

import com.imgarena.licensing.tennis.dto.TennisTournamentResponseDTO;
import com.imgarena.licensing.tennis.model.TennisTournament;

import java.util.stream.Collectors;

public class TennisTournamentMapper {
    public static TennisTournamentResponseDTO convertToTennisTournamentResponseDTO(TennisTournament tennisTournament) {
        return TennisTournamentResponseDTO.builder()
                .tennisTournamentId(tennisTournament.getId())
                .tennisMatches(tennisTournament.getTennisMatches().stream()
                        .map(TennisMatchMapper::convertToTennisMatchResponseDTO)
                        .collect(Collectors.toList()))
                .build();
    }
}
