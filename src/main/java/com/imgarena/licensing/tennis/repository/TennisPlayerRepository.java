package com.imgarena.licensing.tennis.repository;

import com.imgarena.licensing.tennis.identifiers.TennisPlayerId;
import com.imgarena.licensing.tennis.model.TennisPlayer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TennisPlayerRepository extends JpaRepository<TennisPlayer, Long> {
    Optional<TennisPlayer> findByTennisPlayerId(TennisPlayerId tennisPlayerId);
}
