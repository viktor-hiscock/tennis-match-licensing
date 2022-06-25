package com.imgarena.licensing.tennis.service;

import com.imgarena.licensing.tennis.dto.CreateCustomerRequestDTO;
import com.imgarena.licensing.tennis.dto.UpdateCustomerRequestDTO;
import com.imgarena.licensing.tennis.exception.CustomerNotFoundException;
import com.imgarena.licensing.tennis.identifiers.CustomerId;
import com.imgarena.licensing.tennis.model.Customer;
import com.imgarena.licensing.tennis.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@AllArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;

    public Customer getCustomer(CustomerId customerId) {
        return customerRepository.findByCustomerId(customerId)
                .orElseThrow(() -> new CustomerNotFoundException(customerId));
    }

    public Customer createCustomer(CreateCustomerRequestDTO createCustomerRequestDTO) {
        Customer newCustomer = Customer.builder()
                .customerId(new CustomerId(createCustomerRequestDTO.getCustomerId()))
                .firstName(createCustomerRequestDTO.getFirstName())
                .lastName(createCustomerRequestDTO.getLastName())
                .dateOfBirth(LocalDate.parse(createCustomerRequestDTO.getDateOfBirth()))
                .build();
        return customerRepository.save(newCustomer);
    }

    public Customer updateCustomer(CustomerId customerId, UpdateCustomerRequestDTO updateCustomerRequestDTO) {
        Customer currentCustomer = customerRepository.findByCustomerId(customerId)
                .orElseThrow(() -> new CustomerNotFoundException(customerId));
        currentCustomer.setFirstName(updateCustomerRequestDTO.getFirstName());
        currentCustomer.setLastName(updateCustomerRequestDTO.getLastName());
        currentCustomer.setDateOfBirth(LocalDate.parse(updateCustomerRequestDTO.getDateOfBirth()));
        return customerRepository.save(currentCustomer);
    }
}
