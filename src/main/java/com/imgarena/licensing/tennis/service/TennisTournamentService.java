package com.imgarena.licensing.tennis.service;

import com.imgarena.licensing.tennis.dto.CreateTennisTournamentRequestDTO;
import com.imgarena.licensing.tennis.model.TennisMatch;
import com.imgarena.licensing.tennis.model.TennisTournament;
import com.imgarena.licensing.tennis.repository.TennisTournamentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TennisTournamentService {
    private final TennisMatchService tennisMatchService;
    private final TennisTournamentRepository tennisTournamentRepository;

    public TennisTournament createTennisTournament(CreateTennisTournamentRequestDTO createTennisTournamentRequestDTO) {
        List<TennisMatch> tennisMatches = createTennisTournamentRequestDTO.getTennisMatchIds().stream()
                .map(tennisMatchService::getTennisMatch)
                .collect(Collectors.toList());
        TennisTournament newTennisTournament = TennisTournament.builder()
                .tennisMatches(tennisMatches)
                .build();
        return tennisTournamentRepository.save(newTennisTournament);
    }
}
