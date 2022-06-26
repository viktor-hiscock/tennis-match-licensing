package com.imgarena.licensing.tennis.service;

import com.imgarena.licensing.tennis.dto.TennisMatchRequestDTO;
import com.imgarena.licensing.tennis.exception.TennisMatchNotFoundException;
import com.imgarena.licensing.tennis.model.TennisMatch;
import com.imgarena.licensing.tennis.model.TennisPlayer;
import com.imgarena.licensing.tennis.repository.TennisMatchRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TennisMatchService {
    private final TennisPlayerService tennisPlayerService;
    private final TennisMatchRepository tennisMatchRepository;
    private final PaginationService<TennisMatch> tennisMatchPaginationService;

    public TennisMatch getTennisMatch(Long tennisMatchId) {
        return tennisMatchRepository.findById(tennisMatchId)
                .orElseThrow(() -> new TennisMatchNotFoundException(tennisMatchId));
    }

    public TennisMatch createTennisMatch(TennisMatchRequestDTO tennisMatchRequestDTO) {
        TennisPlayer tennisPlayerA = tennisPlayerService.getTennisPlayer(tennisMatchRequestDTO.getTennisPlayerAId());
        TennisPlayer tennisPlayerB = tennisPlayerService.getTennisPlayer(tennisMatchRequestDTO.getTennisPlayerBId());
        TennisMatch newTennisMatch = TennisMatch.builder()
                .playerA(tennisPlayerA)
                .playerB(tennisPlayerB)
                .startDate(LocalDateTime.parse(tennisMatchRequestDTO.getStartDate().getTimestamp()))
                .zoneId(Optional.ofNullable(tennisMatchRequestDTO.getStartDate().getZoneId())
                        .map(ZoneId::of)
                        .orElse(ZoneId.of("UTC")))
                .build();
        return tennisMatchRepository.save(newTennisMatch);
    }

    @Transactional
    public TennisMatch updateTennisMatch(Long tennisMatchId, TennisMatchRequestDTO tennisMatchRequestDTO) {
        TennisMatch currentTennisMatch = getTennisMatch(tennisMatchId);
        currentTennisMatch.setPlayerA(tennisPlayerService.getTennisPlayer(tennisMatchRequestDTO.getTennisPlayerAId()));
        currentTennisMatch.setPlayerB(tennisPlayerService.getTennisPlayer(tennisMatchRequestDTO.getTennisPlayerBId()));
        currentTennisMatch.setStartDate(LocalDateTime.parse(tennisMatchRequestDTO.getStartDate().getTimestamp()));
        currentTennisMatch.setZoneId(Optional.ofNullable(tennisMatchRequestDTO.getStartDate().getZoneId())
                .map(ZoneId::of)
                .orElse(ZoneId.of("UTC")));
        return currentTennisMatch;
    }

    public TennisMatch deleteTennisMatch(Long tennisMatchId) {
        TennisMatch tennisMatchToDelete = getTennisMatch(tennisMatchId);
        tennisMatchRepository.delete(tennisMatchToDelete);
        return tennisMatchToDelete;
    }

    public List<TennisMatch> getAllTennisMatches(int pageNumber, int pageSize) {
        return tennisMatchPaginationService.getPaginatedRecords(pageNumber, pageSize, tennisMatchRepository);
    }
}
