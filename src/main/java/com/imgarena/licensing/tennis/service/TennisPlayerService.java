package com.imgarena.licensing.tennis.service;

import com.imgarena.licensing.tennis.dto.CreateTennisPlayerRequestDTO;
import com.imgarena.licensing.tennis.dto.UpdateTennisPlayerRequestDTO;
import com.imgarena.licensing.tennis.exception.TennisPlayerNotFoundException;
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

    public TennisPlayer getTennisPlayer(Long tennisPlayerId) {
        return tennisPlayerRepository.findById(tennisPlayerId)
                .orElseThrow(() -> new TennisPlayerNotFoundException(tennisPlayerId));
    }

    public TennisPlayer createTennisPlayer(CreateTennisPlayerRequestDTO createTennisPlayerRequestDTO) {
        TennisPlayer newTennisPlayer = TennisPlayer.builder()
                .firstName(createTennisPlayerRequestDTO.getFirstName())
                .lastName(createTennisPlayerRequestDTO.getLastName())
                .build();
        return tennisPlayerRepository.save(newTennisPlayer);
    }

    public TennisPlayer updateTennisPlayer(Long tennisPlayerId, UpdateTennisPlayerRequestDTO updateTennisPlayerRequestDTO) {
        TennisPlayer currentTennisPlayer = tennisPlayerRepository.findById(tennisPlayerId)
                .orElseThrow(() -> new TennisPlayerNotFoundException(tennisPlayerId));
        currentTennisPlayer.setFirstName(updateTennisPlayerRequestDTO.getFirstName());
        currentTennisPlayer.setLastName(updateTennisPlayerRequestDTO.getLastName());
        tennisPlayerRepository.save(currentTennisPlayer);
        return currentTennisPlayer;
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
