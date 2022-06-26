package com.imgarena.licensing.tennis.mapper;

import com.imgarena.licensing.tennis.dto.CustomerResponseDTO;
import com.imgarena.licensing.tennis.dto.TennisMatchSummaryType;
import com.imgarena.licensing.tennis.model.Customer;
import com.imgarena.licensing.tennis.model.TennisMatch;
import com.imgarena.licensing.tennis.model.TennisMatchLicense;
import com.imgarena.licensing.tennis.model.TennisTournament;
import com.imgarena.licensing.tennis.model.TennisTournamentLicense;

import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CustomerMapper {
    public static CustomerResponseDTO convertToCustomerResponseDTO(Customer customer, TennisMatchSummaryType tennisMatchSummaryType) {
        Set<TennisMatch> deduplicatedTennisMatches = deduplicateTennisMatches(customer.getTennisMatchLicenses(), customer.getTennisTournamentLicenses());

        return CustomerResponseDTO.builder()
                .tennisMatches(deduplicatedTennisMatches.stream()
                        .map(tennisMatch -> TennisMatchMapper.convertToTennisMatchResponseDTO(tennisMatch, tennisMatchSummaryType))
                        .collect(Collectors.toList()))
                .build();
    }

    private static Set<TennisMatch> deduplicateTennisMatches(List<TennisMatchLicense> tennisMatchLicenses, List<TennisTournamentLicense> tennisTournamentLicenses) {
        List<TennisMatch> tennisMatchesFromMatchLicenses = tennisMatchLicenses.stream()
                .map(TennisMatchLicense::getTennisMatch)
                .collect(Collectors.toList());
        List<TennisMatch> tennisMatchesFromTournamentLicenses = tennisTournamentLicenses.stream()
                .map(TennisTournamentLicense::getTennisTournament)
                .map(TennisTournament::getTennisMatches)
                .flatMap(List::stream)
                .collect(Collectors.toList());
        return Stream.concat(tennisMatchesFromMatchLicenses.stream(), tennisMatchesFromTournamentLicenses.stream())
                .collect(Collectors.toSet());
    }
}
