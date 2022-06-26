package com.imgarena.licensing.tennis.repository;

import com.imgarena.licensing.tennis.model.TennisMatch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TennisMatchRepository extends JpaRepository<TennisMatch, Long> {
}
