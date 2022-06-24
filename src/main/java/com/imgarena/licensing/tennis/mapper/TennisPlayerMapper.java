package com.imgarena.licensing.tennis.mapper;

import com.imgarena.licensing.tennis.dto.TennisPlayerDTO;
import com.imgarena.licensing.tennis.identifiers.TennisPlayerId;
import com.imgarena.licensing.tennis.model.TennisPlayer;

public class TennisPlayerMapper {
    public static TennisPlayer convertToTennisPlayer(TennisPlayerDTO tennisPlayerDTO) {
        return TennisPlayer.builder()
                .tennisPlayerId(new TennisPlayerId(tennisPlayerDTO.getTennisPlayerId()))
                .firstName(tennisPlayerDTO.getFirstName())
                .lastName(tennisPlayerDTO.getLastName())
                .build();
    }

    public static TennisPlayerDTO convertToTennisPlayerDTO(TennisPlayer tennisPlayer) {
        return TennisPlayerDTO.builder()
                .tennisPlayerId(tennisPlayer.getTennisPlayerId().identifier())
                .firstName(tennisPlayer.getFirstName())
                .lastName(tennisPlayer.getLastName())
                .build();
    }
}
