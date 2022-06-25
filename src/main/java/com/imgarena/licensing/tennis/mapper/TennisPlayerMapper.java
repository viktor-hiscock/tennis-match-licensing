package com.imgarena.licensing.tennis.mapper;

import com.imgarena.licensing.tennis.dto.TennisPlayerResponseDTO;
import com.imgarena.licensing.tennis.model.TennisPlayer;

public class TennisPlayerMapper {
    public static TennisPlayerResponseDTO convertToTennisPlayerResponseDTO(TennisPlayer tennisPlayer) {
        return TennisPlayerResponseDTO.builder()
                .tennisPlayerId(tennisPlayer.getId())
                .firstName(tennisPlayer.getFirstName())
                .lastName(tennisPlayer.getLastName())
                .build();
    }
}
