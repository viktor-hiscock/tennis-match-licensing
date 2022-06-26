package com.imgarena.licensing.tennis.service;

import com.imgarena.licensing.tennis.dto.CustomerRequestDTO;
import com.imgarena.licensing.tennis.exception.CustomerNotFoundException;
import com.imgarena.licensing.tennis.model.Customer;
import com.imgarena.licensing.tennis.model.TennisMatchLicense;
import com.imgarena.licensing.tennis.model.TennisTournamentLicense;
import com.imgarena.licensing.tennis.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
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
        Customer currentCustomer = customerRepository.findById(customerId)
                .orElseThrow(() -> new CustomerNotFoundException(customerId));
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
        Optional<Customer> customerToDelete = customerRepository.findById(customerId);
        if (customerToDelete.isPresent()) {
            customerRepository.delete(customerToDelete.get());
        } else {
            throw new CustomerNotFoundException(customerId);
        }
        return customerToDelete.get();
    }

    public List<Customer> getAllCustomers(int pageNumber, int pageSize, String sortBy) {
        Pageable paging = PageRequest.of(pageNumber, pageSize, Sort.by(sortBy));
        Page<Customer> pagedResult = customerRepository.findAll(paging);

        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<>();
        }
    }
}
