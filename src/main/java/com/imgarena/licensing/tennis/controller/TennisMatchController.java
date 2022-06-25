package com.imgarena.licensing.tennis.controller;

import com.imgarena.licensing.tennis.dto.CreateTennisMatchRequestDTO;
import com.imgarena.licensing.tennis.dto.TennisMatchResponseDTO;
import com.imgarena.licensing.tennis.dto.UpdateTennisMatchRequestDTO;
import com.imgarena.licensing.tennis.identifiers.MatchId;
import com.imgarena.licensing.tennis.mapper.TennisMatchMapper;
import com.imgarena.licensing.tennis.model.TennisMatch;
import com.imgarena.licensing.tennis.service.TennisMatchService;
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
public class TennisMatchController {
    private final TennisMatchService tennisMatchService;

    @GetMapping("v1/tennis/match/{matchId}")
    public ResponseEntity<TennisMatchResponseDTO> getTennisMatch(@PathVariable("matchId") String matchId) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(TennisMatchMapper.convertToTennisMatchResponseDTO(tennisMatchService.getTennisMatch(new MatchId(matchId))));
    }

    @PostMapping("v1/tennis/match")
    public ResponseEntity<TennisMatchResponseDTO> createTennisMatch(@RequestBody @Valid CreateTennisMatchRequestDTO createTennisMatchRequestDTO) {
        TennisMatch createdTennisMatch = tennisMatchService.createTennisMatch(createTennisMatchRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(TennisMatchMapper.convertToTennisMatchResponseDTO(createdTennisMatch));
    }

    @PutMapping("v1/tennis/match/{matchId}")
    public ResponseEntity<TennisMatchResponseDTO> updateTennisMatch(
            @PathVariable("matchId") String matchId,
            @RequestBody @Valid UpdateTennisMatchRequestDTO updateTennisMatchRequestDTO
    ) {
        TennisMatch updatedTennisMatch = tennisMatchService.updateTennisMatch(new MatchId(matchId), updateTennisMatchRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(TennisMatchMapper.convertToTennisMatchResponseDTO(updatedTennisMatch));
    }

    @DeleteMapping("v1/tennis/match/{matchId}")
    public ResponseEntity<TennisMatchResponseDTO> deleteTennisMatch(@PathVariable("matchId") String matchId) {
        TennisMatch deletedTennisMatch = tennisMatchService.deleteTennisMatch(new MatchId(matchId));
        return ResponseEntity.status(HttpStatus.OK)
                .body(TennisMatchMapper.convertToTennisMatchResponseDTO(deletedTennisMatch));
    }

    @GetMapping("v1/tennis/match")
    public ResponseEntity<List<TennisMatchResponseDTO>> getAllTennisMatches(
            @RequestParam(defaultValue = "0") int pageNumber,
            @RequestParam(defaultValue = "10") int pageSize,
            @RequestParam(defaultValue = "id") String sortBy
    ) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(tennisMatchService.getAllTennisMatches(pageNumber, pageSize, sortBy).stream()
                        .map(TennisMatchMapper::convertToTennisMatchResponseDTO)
                        .collect(Collectors.toList()));
    }
}
