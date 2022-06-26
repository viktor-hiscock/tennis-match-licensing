package com.imgarena.licensing.tennis.service;

import com.imgarena.licensing.tennis.dto.TennisPlayerRequestDTO;
import com.imgarena.licensing.tennis.exception.TennisPlayerNotFoundException;
import com.imgarena.licensing.tennis.model.TennisPlayer;
import com.imgarena.licensing.tennis.repository.TennisPlayerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class TennisPlayerServiceTest {
    private static final Long TENNIS_PLAYER_ID = 1L;
    private static final String FIRST_NAME = "FIRST_NAME";
    private static final String LAST_NAME = "LAST_NAME";

    @Mock
    private TennisPlayerRepository tennisPlayerRepository;
    @Mock
    private PaginationService<TennisPlayer> tennisPlayerPaginationService;
    private TennisPlayerService tennisPlayerService;

    @BeforeEach
    public void initTest() {
        MockitoAnnotations.openMocks(this);
        tennisPlayerService = new TennisPlayerService(tennisPlayerRepository, tennisPlayerPaginationService);
    }

    @Test
    public void shouldGetTennisPlayer() {
        // given
        TennisPlayer tennisPlayer = Mockito.mock(TennisPlayer.class);
        Mockito.when(tennisPlayerRepository.findById(TENNIS_PLAYER_ID)).thenReturn(Optional.of(tennisPlayer));

        // when
        TennisPlayer queriedTennisPlayer = tennisPlayerService.getTennisPlayer(TENNIS_PLAYER_ID);

        // then
        assertEquals(tennisPlayer, queriedTennisPlayer);
    }

    @Test
    public void shouldThrowExceptionWhenGettingTennisPlayerThatDoesNotExist() {
        // given
        Mockito.when(tennisPlayerRepository.findById(TENNIS_PLAYER_ID)).thenReturn(Optional.empty());

        // when / then
        assertThrows(TennisPlayerNotFoundException.class, () -> tennisPlayerService.getTennisPlayer(TENNIS_PLAYER_ID));
    }

    @Test
    public void shouldCreateNewTennisPlayer() {
        // given
        TennisPlayerRequestDTO createTennisPlayerRequestDTO = TennisPlayerRequestDTO.builder()
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .build();

        // when
        tennisPlayerService.createTennisPlayer(createTennisPlayerRequestDTO);

        // then
        TennisPlayer newTennisPlayer = TennisPlayer.builder()
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .build();
        verify(tennisPlayerRepository, times(1)).save(newTennisPlayer);
    }

    @Test
    public void shouldUpdateTennisPlayer() {
        // given
        String updatedFirstName = "updatedFirstName";
        String updatedLastName = "updatedLastName";
        TennisPlayer tennisPlayerToUpdate = TennisPlayer.builder()
                .id(TENNIS_PLAYER_ID)
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .build();
        TennisPlayerRequestDTO updateTennisPlayerRequestDTO = TennisPlayerRequestDTO.builder()
                .firstName(updatedFirstName)
                .lastName(updatedLastName)
                .build();
        Mockito.when(tennisPlayerRepository.findById(TENNIS_PLAYER_ID)).thenReturn(Optional.of(tennisPlayerToUpdate));

        // when
        tennisPlayerService.updateTennisPlayer(TENNIS_PLAYER_ID, updateTennisPlayerRequestDTO);

        // then
        TennisPlayer updatedTennisPlayer = TennisPlayer.builder()
                .id(TENNIS_PLAYER_ID)
                .firstName(updatedFirstName)
                .lastName(updatedLastName)
                .build();
        verify(tennisPlayerRepository, times(1)).save(updatedTennisPlayer);
    }

    @Test
    public void shouldThrowExceptionWhenUpdatingTennisPlayerThatDoesNotExist() {
        // given
        String updatedFirstName = "updatedFirstName";
        String updatedLastName = "updatedLastName";
        TennisPlayerRequestDTO updateTennisPlayerRequestDTO = TennisPlayerRequestDTO.builder()
                .firstName(updatedFirstName)
                .lastName(updatedLastName)
                .build();
        Mockito.when(tennisPlayerRepository.findById(TENNIS_PLAYER_ID)).thenReturn(Optional.empty());

        // when / then
        assertThrows(TennisPlayerNotFoundException.class, () -> tennisPlayerService.updateTennisPlayer(TENNIS_PLAYER_ID, updateTennisPlayerRequestDTO));
    }

    @Test
    public void shouldDeleteTennisPlayer() {
        // given
        TennisPlayer tennisPlayerToDelete = TennisPlayer.builder()
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .build();
        Mockito.when(tennisPlayerRepository.findById(TENNIS_PLAYER_ID)).thenReturn(Optional.of(tennisPlayerToDelete));

        // when
        tennisPlayerService.deleteTennisPlayer(TENNIS_PLAYER_ID);

        // then
        verify(tennisPlayerRepository, times(1)).delete(tennisPlayerToDelete);
    }

    @Test
    public void shouldThrowExceptionWhenDeletingCustomerThatDoesNotExist() {
        // given
        Mockito.when(tennisPlayerRepository.findById(TENNIS_PLAYER_ID)).thenReturn(Optional.empty());

        // when / then
        assertThrows(TennisPlayerNotFoundException.class, () -> tennisPlayerService.deleteTennisPlayer(TENNIS_PLAYER_ID));
    }

    @Test
    public void shouldGetAllTennisPlayers() {
        // given
        int pageNumber = 1;
        int pageSize = 2;
        TennisPlayer tennisPlayerOne = Mockito.mock(TennisPlayer.class);
        TennisPlayer tennisPlayerTwo = Mockito.mock(TennisPlayer.class);
        List<TennisPlayer> storedTennisPlayers = List.of(tennisPlayerOne, tennisPlayerTwo);
        Mockito.when(tennisPlayerPaginationService.getPaginatedRecords(pageNumber, pageSize, tennisPlayerRepository)).thenReturn(storedTennisPlayers);

        // when
        List<TennisPlayer> queriedTennisPlayers = tennisPlayerService.getAllTennisPlayers(pageNumber, pageSize);

        // then
        assertEquals(storedTennisPlayers, queriedTennisPlayers);
    }
}