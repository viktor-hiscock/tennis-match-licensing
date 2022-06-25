package com.imgarena.licensing.tennis.repository;

import com.imgarena.licensing.tennis.model.TennisPlayer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TennisPlayerRepository extends JpaRepository<TennisPlayer, Long> {
}
