package com.imgarena.licensing.tennis.controller;

import com.imgarena.licensing.tennis.dto.TennisTournamentRequestDTO;
import com.imgarena.licensing.tennis.dto.TennisTournamentResponseDTO;
import com.imgarena.licensing.tennis.mapper.TennisTournamentMapper;
import com.imgarena.licensing.tennis.model.TennisTournament;
import com.imgarena.licensing.tennis.service.TennisTournamentService;
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

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class TennisTournamentController {
    private final TennisTournamentService tennisTournamentService;

    @GetMapping("v1/tennis/tournament/{tennisTournamentId}")
    public ResponseEntity<TennisTournamentResponseDTO> getTennisTournament(@PathVariable("tennisTournamentId") Long tennisTournamentId) {
        TennisTournament tennisTournament = tennisTournamentService.getTennisTournament(tennisTournamentId);
        return ResponseEntity.status(HttpStatus.OK)
                .body(TennisTournamentMapper.convertToTennisTournamentResponseDTO(tennisTournament));
    }

    @PostMapping("v1/tennis/tournament")
    public ResponseEntity<TennisTournamentResponseDTO> createTennisTournament(@RequestBody TennisTournamentRequestDTO tennisTournamentRequestDTO) {
        TennisTournament newTennisTournament = tennisTournamentService.createTennisTournament(tennisTournamentRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(TennisTournamentMapper.convertToTennisTournamentResponseDTO(newTennisTournament));
    }

    @PutMapping("v1/tennis/tournament/{tennisTournamentId}")
    public ResponseEntity<TennisTournamentResponseDTO> updateTennisPlayer(
            @PathVariable("tennisTournamentId") Long tennisTournamentId,
            @RequestBody TennisTournamentRequestDTO tennisTournamentRequestDTO
    ) {
        TennisTournament tennisTournament = tennisTournamentService.updateTennisTournament(tennisTournamentId, tennisTournamentRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(TennisTournamentMapper.convertToTennisTournamentResponseDTO(tennisTournament));
    }

    @DeleteMapping("v1/tennis/tournament/{tennisTournamentId}")
    public ResponseEntity<TennisTournamentResponseDTO> deleteTennisTournament(@PathVariable("tennisTournamentId") Long tennisTournamentId) {
        TennisTournament tennisTournament = tennisTournamentService.deleteTennisTournament(tennisTournamentId);
        return ResponseEntity.status(HttpStatus.OK)
                .body(TennisTournamentMapper.convertToTennisTournamentResponseDTO(tennisTournament));
    }

    @GetMapping("v1/tennis/tournament")
    public ResponseEntity<List<TennisTournamentResponseDTO>> getTennisTournaments(
            @RequestParam(defaultValue = "0") int pageNumber,
            @RequestParam(defaultValue = "10") int pageSize,
            @RequestParam(defaultValue = "id") String sortBy
    ) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(tennisTournamentService.getAllTennisTournaments(pageNumber, pageSize, sortBy).stream()
                        .map(TennisTournamentMapper::convertToTennisTournamentResponseDTO)
                        .collect(Collectors.toList()));
    }
}
