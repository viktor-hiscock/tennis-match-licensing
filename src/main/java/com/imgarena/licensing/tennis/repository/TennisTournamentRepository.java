package com.imgarena.licensing.tennis.repository;

import com.imgarena.licensing.tennis.model.TennisTournament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TennisTournamentRepository extends JpaRepository<TennisTournament, Long> {
}
