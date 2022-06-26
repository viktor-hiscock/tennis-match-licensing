package com.imgarena.licensing.tennis.config;

import com.imgarena.licensing.tennis.model.TennisPlayer;
import com.imgarena.licensing.tennis.repository.TennisPlayerRepository;
import com.imgarena.licensing.tennis.service.PaginationService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PaginationConfig {
    @Bean
    public PaginationService<TennisPlayer> tennisPlayerPaginationService(TennisPlayerRepository tennisPlayerRepository) {
        return new PaginationService<>(tennisPlayerRepository);
    }
}
