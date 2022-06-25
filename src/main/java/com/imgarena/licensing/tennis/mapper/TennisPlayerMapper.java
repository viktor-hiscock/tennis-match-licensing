package com.imgarena.licensing.tennis.mapper;

import com.imgarena.licensing.tennis.dto.CreateTennisPlayerRequestDTO;
import com.imgarena.licensing.tennis.dto.TennisPlayerResponseDTO;
import com.imgarena.licensing.tennis.dto.UpdateTennisPlayerRequestDTO;
import com.imgarena.licensing.tennis.identifiers.TennisPlayerId;
import com.imgarena.licensing.tennis.model.TennisPlayer;

public class TennisPlayerMapper {
    public static TennisPlayer convertToTennisPlayer(CreateTennisPlayerRequestDTO createTennisPlayerRequestDTO) {
        return TennisPlayer.builder()
                .tennisPlayerId(new TennisPlayerId(createTennisPlayerRequestDTO.getTennisPlayerId()))
                .firstName(createTennisPlayerRequestDTO.getFirstName())
                .lastName(createTennisPlayerRequestDTO.getLastName())
                .build();
    }

    public static TennisPlayer convertToTennisPlayer(TennisPlayerId tennisPlayerId, UpdateTennisPlayerRequestDTO updateTennisPlayerRequestDTO) {
        return TennisPlayer.builder()
                .tennisPlayerId(tennisPlayerId)
                .firstName(updateTennisPlayerRequestDTO.getFirstName())
                .lastName(updateTennisPlayerRequestDTO.getLastName())
                .build();
    }

    public static TennisPlayerResponseDTO convertToTennisPlayerResponseDTO(TennisPlayer tennisPlayer) {
        return TennisPlayerResponseDTO.builder()
                .tennisPlayerId(tennisPlayer.getTennisPlayerId().identifier())
                .firstName(tennisPlayer.getFirstName())
                .lastName(tennisPlayer.getLastName())
                .build();
    }
}
