package com.imgarena.licensing.tennis.controller;

import com.imgarena.licensing.tennis.dto.TennisPlayerDTO;
import com.imgarena.licensing.tennis.identifiers.TennisPlayerId;
import com.imgarena.licensing.tennis.mapper.TennisPlayerMapper;
import com.imgarena.licensing.tennis.model.TennisPlayer;
import com.imgarena.licensing.tennis.service.TennisPlayerService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class TennisPlayerController {
    private final TennisPlayerService tennisPlayerService;

    @GetMapping("v1/tennis/player")
    public ResponseEntity<TennisPlayerDTO> getTennisPlayer(@RequestParam("tennisPlayerId") String tennisPlayerId) {
        TennisPlayer foundTennisPlayer = tennisPlayerService.getTennisPlayer(new TennisPlayerId(tennisPlayerId));
        return ResponseEntity.ok(TennisPlayerMapper.convertToTennisPlayerDTO(foundTennisPlayer));
    }

    @PostMapping("v1/tennis/player")
    public ResponseEntity<TennisPlayerDTO> createTennisPlayer(@RequestBody TennisPlayerDTO tennisPlayerDTO) {
        TennisPlayer newTennisPlayer = tennisPlayerService.createTennisPlayer(TennisPlayerMapper.convertToTennisPlayer(tennisPlayerDTO));
        return ResponseEntity.ok(TennisPlayerMapper.convertToTennisPlayerDTO(newTennisPlayer));
    }
}
