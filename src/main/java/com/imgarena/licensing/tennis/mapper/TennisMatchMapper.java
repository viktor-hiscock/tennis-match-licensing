package com.imgarena.licensing.tennis.mapper;

import com.imgarena.licensing.tennis.dto.StartDateDTO;
import com.imgarena.licensing.tennis.dto.TennisMatchResponseDTO;
import com.imgarena.licensing.tennis.model.TennisMatch;

import java.time.format.DateTimeFormatter;

public class TennisMatchMapper {
    public static TennisMatchResponseDTO convertToTennisMatchResponseDTO(TennisMatch tennisMatch) {
        return TennisMatchResponseDTO.builder()
                .matchId(tennisMatch.getId())
                .tennisPlayerA(TennisPlayerMapper.convertToTennisPlayerResponseDTO(tennisMatch.getPlayerA()))
                .tennisPlayerB(TennisPlayerMapper.convertToTennisPlayerResponseDTO(tennisMatch.getPlayerB()))
                .startDate(StartDateDTO.builder()
                        .timestamp(tennisMatch.getStartDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")))
                        .zoneId(tennisMatch.getZoneId().toString())
                        .build())
                .build();
    }
}
