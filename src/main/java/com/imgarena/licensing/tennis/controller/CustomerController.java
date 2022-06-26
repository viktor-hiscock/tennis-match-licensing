package com.imgarena.licensing.tennis.controller;

import com.imgarena.licensing.tennis.dto.CustomerRequestDTO;
import com.imgarena.licensing.tennis.dto.CustomerResponseDTO;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping("v1/customer/{customerId}")
    public ResponseEntity<CustomerResponseDTO> getCustomer(@PathVariable("customerId") Long customerId) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(CustomerMapper.convertToCustomerResponseDTO(customerService.getCustomer(customerId)));
    }

    @PostMapping("v1/customer")
    public ResponseEntity<CustomerResponseDTO> createCustomer(@RequestBody CustomerRequestDTO customerRequestDTO) {
        Customer newCustomer = customerService.createCustomer(customerRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(CustomerMapper.convertToCustomerResponseDTO(newCustomer));
    }

    @PutMapping("v1/customer/{customerId}")
    public ResponseEntity<CustomerResponseDTO> updateCustomer(
            @PathVariable("customerId") Long customerId,
            @RequestBody CustomerRequestDTO customerRequestDTO
    ) {
        Customer updatedCustomer = customerService.updateCustomer(customerId, customerRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(CustomerMapper.convertToCustomerResponseDTO(updatedCustomer));
    }

    @DeleteMapping("v1/customer/{customerId}")
    public ResponseEntity<CustomerResponseDTO> deleteCustomer(@PathVariable("customerId") Long customerId) {
        Customer deletedCustomer = customerService.deleteCustomer(customerId);
        return ResponseEntity.status(HttpStatus.OK)
                .body(CustomerMapper.convertToCustomerResponseDTO(deletedCustomer));
    }

    @GetMapping("v1/customer")
    public ResponseEntity<List<CustomerResponseDTO>> getAllCustomers(
            @RequestParam(defaultValue = "0") int pageNumber,
            @RequestParam(defaultValue = "10") int pageSize,
            @RequestParam(defaultValue = "id") String sortBy
    ) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(customerService.getAllCustomers(pageNumber, pageSize, sortBy).stream()
                        .map(CustomerMapper::convertToCustomerResponseDTO)
                        .collect(Collectors.toList()));
    }
}
