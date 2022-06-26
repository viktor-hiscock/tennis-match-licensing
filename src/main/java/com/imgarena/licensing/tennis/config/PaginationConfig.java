package com.imgarena.licensing.tennis.config;

import com.imgarena.licensing.tennis.model.Customer;
import com.imgarena.licensing.tennis.model.TennisMatch;
import com.imgarena.licensing.tennis.model.TennisMatchLicense;
import com.imgarena.licensing.tennis.model.TennisPlayer;
import com.imgarena.licensing.tennis.model.TennisTournament;
import com.imgarena.licensing.tennis.model.TennisTournamentLicense;
import com.imgarena.licensing.tennis.repository.CustomerRepository;
import com.imgarena.licensing.tennis.repository.TennisMatchLicenseRepository;
import com.imgarena.licensing.tennis.repository.TennisMatchRepository;
import com.imgarena.licensing.tennis.repository.TennisPlayerRepository;
import com.imgarena.licensing.tennis.repository.TennisTournamentLicenseRepository;
import com.imgarena.licensing.tennis.repository.TennisTournamentRepository;
import com.imgarena.licensing.tennis.service.PaginationService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PaginationConfig {
    @Bean
    public PaginationService<Customer> customerPaginationService(CustomerRepository customerRepository) {
        return new PaginationService<>(customerRepository);
    }

    @Bean
    public PaginationService<TennisPlayer> tennisPlayerPaginationService(TennisPlayerRepository tennisPlayerRepository) {
        return new PaginationService<>(tennisPlayerRepository);
    }

    @Bean
    public PaginationService<TennisMatchLicense> tennisMatchLicensePaginationService(TennisMatchLicenseRepository tennisMatchLicenseRepository) {
        return new PaginationService<>(tennisMatchLicenseRepository);
    }

    @Bean
    public PaginationService<TennisMatch> tennisMatchPaginationService(TennisMatchRepository tennisMatchRepository) {
        return new PaginationService<>(tennisMatchRepository);
    }

    @Bean
    public PaginationService<TennisTournamentLicense> tennisTournamentLicensePaginationService(TennisTournamentLicenseRepository tennisTournamentLicenseRepository) {
        return new PaginationService<>(tennisTournamentLicenseRepository);
    }
    @Bean
    public PaginationService<TennisTournament> tennisTournamentPaginationService(TennisTournamentRepository tennisTournamentRepository) {
        return new PaginationService<>(tennisTournamentRepository);
    }
}
