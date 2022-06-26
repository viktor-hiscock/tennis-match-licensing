package com.imgarena.licensing.tennis.controller;

import com.imgarena.licensing.tennis.dto.TennisPlayerRequestDTO;
import com.imgarena.licensing.tennis.dto.TennisPlayerResponseDTO;
import com.imgarena.licensing.tennis.mapper.TennisPlayerMapper;
import com.imgarena.licensing.tennis.model.TennisPlayer;
import com.imgarena.licensing.tennis.service.TennisPlayerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class TennisPlayerController {
    private final TennisPlayerService tennisPlayerService;

    @GetMapping("v1/tennis/player/{tennisPlayerId}")
    public ResponseEntity<TennisPlayerResponseDTO> getTennisPlayer(@PathVariable("tennisPlayerId") Long tennisPlayerId) {
        TennisPlayer foundTennisPlayer = tennisPlayerService.getTennisPlayer(tennisPlayerId);
        return ResponseEntity.ok(TennisPlayerMapper.convertToTennisPlayerResponseDTO(foundTennisPlayer));
    }

    @PostMapping("v1/tennis/player")
    public ResponseEntity<TennisPlayerResponseDTO> createTennisPlayer(@RequestBody @Valid TennisPlayerRequestDTO tennisPlayerRequestDTO) {
        TennisPlayer newTennisPlayer = tennisPlayerService.createTennisPlayer(tennisPlayerRequestDTO);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(TennisPlayerMapper.convertToTennisPlayerResponseDTO(newTennisPlayer));
    }

    @PutMapping("v1/tennis/player/{tennisPlayerId}")
    public ResponseEntity<TennisPlayerResponseDTO> updateTennisPlayer(
            @PathVariable(value = "tennisPlayerId") Long tennisPlayerId,
            @RequestBody @Valid TennisPlayerRequestDTO tennisPlayerRequestDTO
    ) {
        TennisPlayer updatedTennisPlayer = tennisPlayerService.updateTennisPlayer(tennisPlayerId, tennisPlayerRequestDTO);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(TennisPlayerMapper.convertToTennisPlayerResponseDTO(updatedTennisPlayer));
    }

    @DeleteMapping("v1/tennis/player/{tennisPlayerId}")
    public ResponseEntity<TennisPlayerResponseDTO> deleteTennisPlayer(@PathVariable("tennisPlayerId") Long tennisPlayerId) {
        TennisPlayer deletedTennisPlayer = tennisPlayerService.deleteTennisPlayer(tennisPlayerId);
        return ResponseEntity.status(HttpStatus.OK)
                .body(TennisPlayerMapper.convertToTennisPlayerResponseDTO(deletedTennisPlayer));
    }

    @GetMapping("v1/tennis/player")
    public ResponseEntity<List<TennisPlayerResponseDTO>> getAllTennisPlayers(
            @RequestParam(defaultValue = "0") int pageNumber,
            @RequestParam(defaultValue = "10") int pageSize
    ) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(tennisPlayerService.getAllTennisPlayers(pageNumber, pageSize).stream()
                                .map(TennisPlayerMapper::convertToTennisPlayerResponseDTO)
                                .collect(Collectors.toList()));
    }
}
