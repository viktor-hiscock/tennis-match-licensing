package com.imgarena.licensing.tennis.mapper;

import com.imgarena.licensing.tennis.dto.CustomerResponseDTO;
import com.imgarena.licensing.tennis.model.Customer;

import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;

public class CustomerMapper {
    public static CustomerResponseDTO convertToCustomerResponseDTO(Customer customer) {
        return CustomerResponseDTO.builder()
                .customerId(customer.getId())
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .dateOfBirth(customer.getDateOfBirth().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")))
                .createdAt(customer.getCreatedAt().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:ss")))
                .tennisMatchLicenses(customer.getTennisMatchLicenses().stream()
                        .map(TennisMatchLicenseMapper::convertToTennisMatchLicenseResponseDTO)
                        .collect(Collectors.toList()))
                .tennisTournamentLicenses(customer.getTennisTournamentLicenses().stream()
                        .map(TennisTournamentLicenseMapper::convertToTennisTournamentLicenseResponseDTO)
                        .collect(Collectors.toList()))
                .build();
    }
}
