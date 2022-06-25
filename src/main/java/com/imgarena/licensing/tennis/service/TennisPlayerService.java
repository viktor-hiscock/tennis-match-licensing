package com.imgarena.licensing.tennis.service;

import com.imgarena.licensing.tennis.exception.TennisPlayerNotFoundException;
import com.imgarena.licensing.tennis.identifiers.TennisPlayerId;
import com.imgarena.licensing.tennis.model.TennisPlayer;
import com.imgarena.licensing.tennis.repository.TennisPlayerRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    public TennisPlayer updateTennisPlayer(TennisPlayer tennisPlayer) {
        return tennisPlayerRepository.findByTennisPlayerId(tennisPlayer.getTennisPlayerId())
                .map(foundTennisPlayer -> foundTennisPlayer.merge(tennisPlayer))
                .orElseThrow(() -> new TennisPlayerNotFoundException(tennisPlayer.getTennisPlayerId()));
    }

    public List<TennisPlayer> getAllTennisPlayers(int pageNumber, int pageSize, String sortBy) {
        Pageable paging = PageRequest.of(pageNumber, pageSize, Sort.by(sortBy));
        Page<TennisPlayer> pagedResult = tennisPlayerRepository.findAll(paging);

        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<>();
        }
    }
}
