package com.imgarena.licensing.tennis.controller;

import com.imgarena.licensing.tennis.dto.CreateTennisTournamentRequestDTO;
import com.imgarena.licensing.tennis.dto.TennisTournamentResponseDTO;
import com.imgarena.licensing.tennis.mapper.TennisTournamentMapper;
import com.imgarena.licensing.tennis.model.TennisTournament;
import com.imgarena.licensing.tennis.service.TennisTournamentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class TennisTournamentController {
    private final TennisTournamentService tennisTournamentService;

    @PostMapping("v1/tennis/tournament")
    public ResponseEntity<TennisTournamentResponseDTO> createTennisTournament(@RequestBody CreateTennisTournamentRequestDTO createTennisTournamentRequestDTO) {
        TennisTournament newTennisTournament = tennisTournamentService.createTennisTournament(createTennisTournamentRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(TennisTournamentMapper.convertToTennisTournamentResponseDTO(newTennisTournament));
    }
}
