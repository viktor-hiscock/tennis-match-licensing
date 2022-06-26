package com.imgarena.licensing.tennis.service;

import com.imgarena.licensing.tennis.dto.CreateTennisTournamentRequestDTO;
import com.imgarena.licensing.tennis.dto.UpdateTennisTournamentRequestDTO;
import com.imgarena.licensing.tennis.exception.TennisMatchNotFoundException;
import com.imgarena.licensing.tennis.exception.TennisTournamentNotFoundException;
import com.imgarena.licensing.tennis.model.TennisMatch;
import com.imgarena.licensing.tennis.model.TennisTournament;
import com.imgarena.licensing.tennis.repository.TennisTournamentRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TennisTournamentService {
    private final TennisMatchService tennisMatchService;
    private final TennisTournamentRepository tennisTournamentRepository;

    public TennisTournament getTennisTournament(Long tennisTournamentId) {
        return tennisTournamentRepository.findById(tennisTournamentId)
                .orElseThrow(() -> new TennisTournamentNotFoundException(tennisTournamentId));
    }

    public TennisTournament createTennisTournament(CreateTennisTournamentRequestDTO createTennisTournamentRequestDTO) {
        List<TennisMatch> tennisMatches = createTennisTournamentRequestDTO.getTennisMatchIds().stream()
                .map(tennisMatchService::getTennisMatch)
                .collect(Collectors.toList());
        TennisTournament newTennisTournament = TennisTournament.builder()
                .tennisMatches(tennisMatches)
                .build();
        return tennisTournamentRepository.save(newTennisTournament);
    }

    public TennisTournament updateTennisTournament(Long tennisTournamentId, UpdateTennisTournamentRequestDTO updateTennisTournamentRequestDTO) {
        TennisTournament currentTennisTournament = tennisTournamentRepository.findById(tennisTournamentId)
                .orElseThrow(() -> new TennisTournamentNotFoundException(tennisTournamentId));
        List<TennisMatch> updatedTennisMatches = updateTennisTournamentRequestDTO.getTennisMatchIds().stream()
                .map(tennisMatchService::getTennisMatch)
                .collect(Collectors.toList());
        currentTennisTournament.setTennisMatches(updatedTennisMatches);
        return tennisTournamentRepository.save(currentTennisTournament);
    }

    public TennisTournament deleteTennisTournament(Long tennisTournamentId) {
        Optional<TennisTournament> tennisTournamentToDelete = tennisTournamentRepository.findById(tennisTournamentId);
        if (tennisTournamentToDelete.isPresent()) {
            tennisTournamentRepository.delete(tennisTournamentToDelete.get());
        } else {
            throw new TennisMatchNotFoundException(tennisTournamentId);
        }
        return tennisTournamentToDelete.get();
    }

    public List<TennisTournament> getAllTennisTournaments(int pageNumber, int pageSize, String sortBy) {
        Pageable paging = PageRequest.of(pageNumber, pageSize, Sort.by(sortBy));
        Page<TennisTournament> pagedResult = tennisTournamentRepository.findAll(paging);

        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<>();
        }
    }
}
