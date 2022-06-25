package com.imgarena.licensing.tennis.mapper;

import com.imgarena.licensing.tennis.dto.CustomerResponseDTO;
import com.imgarena.licensing.tennis.model.Customer;

import java.time.format.DateTimeFormatter;

public class CustomerMapper {
    public static CustomerResponseDTO convertToCustomerResponseDTO(Customer customer) {
        return CustomerResponseDTO.builder()
                .customerId(customer.getCustomerId().identifier())
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .dateOfBirth(customer.getDateOfBirth().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")))
                .createdAt(customer.getCreatedAt().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:ss")))
                .build();
    }
}
