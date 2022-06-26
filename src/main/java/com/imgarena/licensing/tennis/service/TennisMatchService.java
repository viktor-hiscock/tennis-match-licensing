package com.imgarena.licensing.tennis.service;

import com.imgarena.licensing.tennis.dto.TennisMatchRequestDTO;
import com.imgarena.licensing.tennis.exception.TennisMatchNotFoundException;
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
        TennisMatch managedTennisMatch = tennisMatchRepository.findById(tennisMatchId)
                .orElseThrow(() -> new TennisMatchNotFoundException(tennisMatchId));
        managedTennisMatch.setPlayerA(tennisPlayerService.getTennisPlayer(tennisMatchRequestDTO.getTennisPlayerAId()));
        managedTennisMatch.setPlayerB(tennisPlayerService.getTennisPlayer(tennisMatchRequestDTO.getTennisPlayerBId()));
        managedTennisMatch.setStartDate(LocalDateTime.parse(tennisMatchRequestDTO.getStartDate().getTimestamp()));
        managedTennisMatch.setZoneId(Optional.ofNullable(tennisMatchRequestDTO.getStartDate().getZoneId())
                .map(ZoneId::of)
                .orElse(ZoneId.of("UTC")));
        return managedTennisMatch;
    }

    public TennisMatch deleteTennisMatch(Long tennisMatchId) {
        Optional<TennisMatch> tennisMatchToDelete = tennisMatchRepository.findById(tennisMatchId);
        if (tennisMatchToDelete.isPresent()) {
            tennisMatchRepository.delete(tennisMatchToDelete.get());
        } else {
            throw new TennisMatchNotFoundException(tennisMatchId);
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
