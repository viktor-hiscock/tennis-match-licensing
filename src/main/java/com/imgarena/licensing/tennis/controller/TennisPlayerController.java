package com.imgarena.licensing.tennis.controller;

import com.imgarena.licensing.tennis.dto.CreateTennisPlayerRequestDTO;
import com.imgarena.licensing.tennis.dto.TennisPlayerResponseDTO;
import com.imgarena.licensing.tennis.dto.UpdateTennisPlayerRequestDTO;
import com.imgarena.licensing.tennis.identifiers.TennisPlayerId;
import com.imgarena.licensing.tennis.mapper.TennisPlayerMapper;
import com.imgarena.licensing.tennis.model.TennisPlayer;
import com.imgarena.licensing.tennis.service.TennisPlayerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
public class TennisPlayerController {
    private final TennisPlayerService tennisPlayerService;

    @GetMapping("v1/tennis/player/{tennisPlayerId}")
    public ResponseEntity<TennisPlayerResponseDTO> getTennisPlayer(@PathVariable("tennisPlayerId") String tennisPlayerId) {
        TennisPlayer foundTennisPlayer = tennisPlayerService.getTennisPlayer(new TennisPlayerId(tennisPlayerId));
        return ResponseEntity.ok(TennisPlayerMapper.convertToTennisPlayerResponseDTO(foundTennisPlayer));
    }

    @PostMapping("v1/tennis/player")
    public ResponseEntity<TennisPlayerResponseDTO> createTennisPlayer(@RequestBody @Valid CreateTennisPlayerRequestDTO createTennisPlayerRequestDTO) {
        TennisPlayer newTennisPlayer = tennisPlayerService.createTennisPlayer(TennisPlayerMapper.convertToTennisPlayer(createTennisPlayerRequestDTO));
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(TennisPlayerMapper.convertToTennisPlayerResponseDTO(newTennisPlayer));
    }

    @PutMapping("v1/tennis/player/{tennisPlayerId}")
    public ResponseEntity<TennisPlayerResponseDTO> updateTennisPlayer(
            @PathVariable(value = "tennisPlayerId") String tennisPlayerId,
            @RequestBody @Valid UpdateTennisPlayerRequestDTO updateTennisPlayerRequestDTO
    ) {
        TennisPlayer updatedTennisPlayer = tennisPlayerService.updateTennisPlayer(TennisPlayerMapper.convertToTennisPlayer(new TennisPlayerId(tennisPlayerId), updateTennisPlayerRequestDTO));
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(TennisPlayerMapper.convertToTennisPlayerResponseDTO(updatedTennisPlayer));
    }
}
