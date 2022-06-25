package com.imgarena.licensing.tennis.service;

import com.imgarena.licensing.tennis.dto.CreateTennisMatchRequestDTO;
import com.imgarena.licensing.tennis.dto.UpdateTennisMatchRequestDTO;
import com.imgarena.licensing.tennis.exception.TennisMatchNotFoundException;
import com.imgarena.licensing.tennis.identifiers.MatchId;
import com.imgarena.licensing.tennis.identifiers.TennisPlayerId;
import com.imgarena.licensing.tennis.model.TennisMatch;
import com.imgarena.licensing.tennis.model.TennisPlayer;
import com.imgarena.licensing.tennis.repository.TennisMatchRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TennisMatchService {
    private final TennisPlayerService tennisPlayerService;
    private final TennisMatchRepository tennisMatchRepository;

    public TennisMatch getTennisMatch(MatchId matchId) {
        return tennisMatchRepository.findByMatchId(matchId)
                .orElseThrow(() -> new TennisMatchNotFoundException(matchId));
    }

    public TennisMatch createTennisMatch(CreateTennisMatchRequestDTO createTennisMatchRequestDTO) {
        TennisPlayer tennisPlayerA = tennisPlayerService.getTennisPlayer(new TennisPlayerId(createTennisMatchRequestDTO.getTennisPlayerAId()));
        TennisPlayer tennisPlayerB = tennisPlayerService.getTennisPlayer(new TennisPlayerId(createTennisMatchRequestDTO.getTennisPlayerBId()));
        TennisMatch newTennisMatch = TennisMatch.builder()
                .matchId(new MatchId(createTennisMatchRequestDTO.getMatchId()))
                .playerA(tennisPlayerA)
                .playerB(tennisPlayerB)
                .startDate(LocalDateTime.parse(createTennisMatchRequestDTO.getStartDate().getTimestamp()))
                .zoneId(Optional.ofNullable(createTennisMatchRequestDTO.getStartDate().getZoneId())
                        .map(ZoneId::of)
                        .orElse(ZoneId.of("UTC")))
                .build();
        return tennisMatchRepository.save(newTennisMatch);
    }

    @Transactional
    public TennisMatch updateTennisMatch(MatchId matchId, UpdateTennisMatchRequestDTO updateTennisMatchRequestDTO) {
        TennisMatch managedTennisMatch = tennisMatchRepository.findByMatchId(matchId)
                .orElseThrow(() -> new TennisMatchNotFoundException(matchId));
        managedTennisMatch.setPlayerA(tennisPlayerService.getTennisPlayer(new TennisPlayerId(updateTennisMatchRequestDTO.getTennisPlayerAId())));
        managedTennisMatch.setPlayerB(tennisPlayerService.getTennisPlayer(new TennisPlayerId(updateTennisMatchRequestDTO.getTennisPlayerBId())));
        managedTennisMatch.setStartDate(LocalDateTime.parse(updateTennisMatchRequestDTO.getStartDate().getTimestamp()));
        managedTennisMatch.setZoneId(Optional.ofNullable(updateTennisMatchRequestDTO.getStartDate().getZoneId())
                .map(ZoneId::of)
                .orElse(ZoneId.of("UTC")));
        return managedTennisMatch;
    }

    public TennisMatch deleteTennisMatch(MatchId matchId) {
        Optional<TennisMatch> tennisMatchToDelete = tennisMatchRepository.findByMatchId(matchId);
        if (tennisMatchToDelete.isPresent()) {
            tennisMatchRepository.delete(tennisMatchToDelete.get());
        } else {
            throw new TennisMatchNotFoundException(matchId);
        }
        return tennisMatchToDelete.get();
    }

    public List<TennisMatch> getAllTennisMatches(int pageNumber, int pageSize, String sortBy) {
        Pageable paging = PageRequest.of(pageNumber, pageSize, Sort.by(sortBy));
        Page<TennisMatch> pagedResult = tennisMatchRepository.findAll(paging);

        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<>();
        }
    }
}
