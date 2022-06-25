package com.imgarena.licensing.tennis.controller;

import com.imgarena.licensing.tennis.dto.CreateCustomerRequestDTO;
import com.imgarena.licensing.tennis.dto.CustomerResponseDTO;
import com.imgarena.licensing.tennis.mapper.CustomerMapper;
import com.imgarena.licensing.tennis.model.Customer;
import com.imgarena.licensing.tennis.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping("v1/customer")
    public ResponseEntity<CustomerResponseDTO> createCustomer(@RequestBody CreateCustomerRequestDTO createCustomerRequestDTO) {
        Customer newCustomer = customerService.createCustomer(createCustomerRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(CustomerMapper.convertToCustomerResponseDTO(newCustomer));
    }
}
