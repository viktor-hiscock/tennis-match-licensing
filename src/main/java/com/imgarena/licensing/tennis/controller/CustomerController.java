package com.imgarena.licensing.tennis.controller;

import com.imgarena.licensing.tennis.dto.CreateCustomerRequestDTO;
import com.imgarena.licensing.tennis.dto.CustomerResponseDTO;
import com.imgarena.licensing.tennis.dto.UpdateCustomerRequestDTO;
import com.imgarena.licensing.tennis.identifiers.CustomerId;
import com.imgarena.licensing.tennis.mapper.CustomerMapper;
import com.imgarena.licensing.tennis.model.Customer;
import com.imgarena.licensing.tennis.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping("v1/customer/{customerId}")
    public ResponseEntity<CustomerResponseDTO> getCustomer(@PathVariable("customerId") String customerId) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(CustomerMapper.convertToCustomerResponseDTO(customerService.getCustomer(new CustomerId(customerId))));
    }

    @PostMapping("v1/customer")
    public ResponseEntity<CustomerResponseDTO> createCustomer(@RequestBody CreateCustomerRequestDTO createCustomerRequestDTO) {
        Customer newCustomer = customerService.createCustomer(createCustomerRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(CustomerMapper.convertToCustomerResponseDTO(newCustomer));
    }

    @PutMapping("v1/customer/{customerId}")
    public ResponseEntity<CustomerResponseDTO> updateCustomer(
            @PathVariable("customerId") String customerId,
            @RequestBody UpdateCustomerRequestDTO updateCustomerRequestDTO
    ) {
        Customer updatedCustomer = customerService.updateCustomer(new CustomerId(customerId), updateCustomerRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(CustomerMapper.convertToCustomerResponseDTO(updatedCustomer));
    }

    @DeleteMapping("v1/customer/{customerId}")
    public ResponseEntity<CustomerResponseDTO> deleteCustomer(@PathVariable("customerId") String customerId) {
        Customer deletedCustomer = customerService.deleteCustomer(new CustomerId(customerId));
        return ResponseEntity.status(HttpStatus.OK)
                .body(CustomerMapper.convertToCustomerResponseDTO(deletedCustomer));
    }
}
