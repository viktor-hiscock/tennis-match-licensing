package com.imgarena.licensing.tennis.service;

import com.imgarena.licensing.tennis.dto.TennisTournamentRequestDTO;
import com.imgarena.licensing.tennis.exception.TennisTournamentNotFoundException;
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
    private final PaginationService<TennisTournament> tennisTournamentPaginationService;

    public TennisTournament getTennisTournament(Long tennisTournamentId) {
        return tennisTournamentRepository.findById(tennisTournamentId)
                .orElseThrow(() -> new TennisTournamentNotFoundException(tennisTournamentId));
    }

    public TennisTournament createTennisTournament(TennisTournamentRequestDTO tennisTournamentRequestDTO) {
        List<TennisMatch> tennisMatches = tennisTournamentRequestDTO.getTennisMatchIds().stream()
                .map(tennisMatchService::getTennisMatch)
                .collect(Collectors.toList());
        TennisTournament newTennisTournament = TennisTournament.builder()
                .tennisMatches(tennisMatches)
                .build();
        return tennisTournamentRepository.save(newTennisTournament);
    }

    public TennisTournament updateTennisTournament(Long tennisTournamentId, TennisTournamentRequestDTO tennisTournamentRequestDTO) {
        TennisTournament currentTennisTournament = getTennisTournament(tennisTournamentId);
        List<TennisMatch> updatedTennisMatches = tennisTournamentRequestDTO.getTennisMatchIds().stream()
                .map(tennisMatchService::getTennisMatch)
                .collect(Collectors.toList());
        currentTennisTournament.setTennisMatches(updatedTennisMatches);
        return tennisTournamentRepository.save(currentTennisTournament);
    }

    public TennisTournament deleteTennisTournament(Long tennisTournamentId) {
        TennisTournament tennisTournamentToDelete = getTennisTournament(tennisTournamentId);
        tennisTournamentRepository.delete(tennisTournamentToDelete);
        return tennisTournamentToDelete;
    }

    public List<TennisTournament> getAllTennisTournaments(int pageNumber, int pageSize) {
        return tennisTournamentPaginationService.getPaginatedRecords(pageNumber, pageSize, tennisTournamentRepository);
    }
}
