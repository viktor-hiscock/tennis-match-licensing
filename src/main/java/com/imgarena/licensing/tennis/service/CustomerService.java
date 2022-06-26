package com.imgarena.licensing.tennis.service;

import com.imgarena.licensing.tennis.dto.CustomerRequestDTO;
import com.imgarena.licensing.tennis.exception.CustomerNotFoundException;
import com.imgarena.licensing.tennis.model.Customer;
import com.imgarena.licensing.tennis.model.TennisMatchLicense;
import com.imgarena.licensing.tennis.model.TennisTournamentLicense;
import com.imgarena.licensing.tennis.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CustomerService {
    private final TennisMatchLicenseService tennisMatchLicenseService;
    private final TennisTournamentLicenseService tennisTournamentLicenseService;
    private final CustomerRepository customerRepository;
    private final PaginationService<Customer> customerPaginationService;

    public Customer getCustomer(Long customerId) {
        return customerRepository.findById(customerId)
                .orElseThrow(() -> new CustomerNotFoundException(customerId));
    }

    public Customer createCustomer(CustomerRequestDTO customerRequestDTO) {
        List<TennisMatchLicense> tennisMatchLicenses = Optional.ofNullable(customerRequestDTO.getTennisMatchLicenseIds())
                .map(tennisMatchLicenseIds -> tennisMatchLicenseIds.stream()
                        .map(tennisMatchLicenseService::getTennisMatchLicense)
                        .collect(Collectors.toList()))
                .orElse(Collections.emptyList());

        List<TennisTournamentLicense> tennisTournamentLicenses = Optional.ofNullable(customerRequestDTO.getTennisTournamentLicenseIds())
                .map(tennisTournamentLicenseIds -> tennisTournamentLicenseIds.stream()
                        .map(tennisTournamentLicenseService::getTennisTournamentLicense)
                        .collect(Collectors.toList()))
                .orElse(Collections.emptyList());

        Customer newCustomer = Customer.builder()
                .firstName(customerRequestDTO.getFirstName())
                .lastName(customerRequestDTO.getLastName())
                .dateOfBirth(LocalDate.parse(customerRequestDTO.getDateOfBirth()))
                .tennisMatchLicenses(tennisMatchLicenses)
                .tennisTournamentLicenses(tennisTournamentLicenses)
                .build();
        return customerRepository.save(newCustomer);
    }

    public Customer updateCustomer(Long customerId, CustomerRequestDTO customerRequestDTO) {
        Customer currentCustomer = getCustomer(customerId);
        List<TennisMatchLicense> tennisMatchLicenses = customerRequestDTO.getTennisMatchLicenseIds().stream()
                .map(tennisMatchLicenseService::getTennisMatchLicense)
                .collect(Collectors.toList());
        List<TennisTournamentLicense> tennisTournamentLicenses = customerRequestDTO.getTennisTournamentLicenseIds().stream()
                .map(tennisTournamentLicenseService::getTennisTournamentLicense)
                .collect(Collectors.toList());
        currentCustomer.setFirstName(customerRequestDTO.getFirstName());
        currentCustomer.setLastName(customerRequestDTO.getLastName());
        currentCustomer.setDateOfBirth(LocalDate.parse(customerRequestDTO.getDateOfBirth()));
        currentCustomer.setTennisMatchLicenses(tennisMatchLicenses);
        currentCustomer.setTennisTournamentLicenses(tennisTournamentLicenses);
        return customerRepository.save(currentCustomer);
    }

    public Customer deleteCustomer(Long customerId) {
        Customer customerToDelete = getCustomer(customerId);
        customerRepository.delete(customerToDelete);
        return customerToDelete;
    }

    public List<Customer> getAllCustomers(int pageNumber, int pageSize) {
        return customerPaginationService.getPaginatedRecords(pageNumber, pageSize, customerRepository);
    }
}
