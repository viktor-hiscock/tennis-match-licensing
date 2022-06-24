package com.imgarena.licensing.tennis.service;

import com.imgarena.licensing.tennis.exception.TennisPlayerNotFoundException;
import com.imgarena.licensing.tennis.identifiers.TennisPlayerId;
import com.imgarena.licensing.tennis.model.TennisPlayer;
import com.imgarena.licensing.tennis.repository.TennisPlayerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TennisPlayerService {
    private final TennisPlayerRepository tennisPlayerRepository;

    public TennisPlayer getTennisPlayer(TennisPlayerId tennisPlayerId) {
        return tennisPlayerRepository.findByTennisPlayerId(tennisPlayerId)
                .orElseThrow(() -> new TennisPlayerNotFoundException(tennisPlayerId));
    }

    public TennisPlayer createTennisPlayer(TennisPlayer tennisPlayer) {
        return tennisPlayerRepository.save(tennisPlayer);
    }
}
