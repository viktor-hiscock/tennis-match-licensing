package com.imgarena.licensing.tennis.repository;

import com.imgarena.licensing.tennis.identifiers.MatchId;
import com.imgarena.licensing.tennis.model.TennisMatch;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TennisMatchRepository extends JpaRepository<TennisMatch, Long> {
    Optional<TennisMatch> findByMatchId(MatchId matchId);
}
