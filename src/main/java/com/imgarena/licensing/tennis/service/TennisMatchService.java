package com.imgarena.licensing.tennis.service;

import com.imgarena.licensing.tennis.dto.CreateTennisMatchRequestDTO;
import com.imgarena.licensing.tennis.exception.TennisMatchNotFoundException;
import com.imgarena.licensing.tennis.identifiers.MatchId;
import com.imgarena.licensing.tennis.identifiers.TennisPlayerId;
import com.imgarena.licensing.tennis.model.TennisMatch;
import com.imgarena.licensing.tennis.model.TennisPlayer;
import com.imgarena.licensing.tennis.repository.TennisMatchRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
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
        TennisMatch tennisMatch = TennisMatch.builder()
                .matchId(new MatchId(createTennisMatchRequestDTO.getMatchId()))
                .playerA(tennisPlayerA)
                .playerB(tennisPlayerB)
                .startDate(LocalDateTime.parse(createTennisMatchRequestDTO.getStartDate().getTimestamp()))
                .zoneId(Optional.ofNullable(createTennisMatchRequestDTO.getStartDate().getZoneId())
                        .map(ZoneId::of)
                        .orElse(ZoneId.of("UTC")))
                .build();
        return tennisMatchRepository.save(tennisMatch);
    }
}
