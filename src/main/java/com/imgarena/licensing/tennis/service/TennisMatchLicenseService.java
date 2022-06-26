package com.imgarena.licensing.tennis.service;

import com.imgarena.licensing.tennis.dto.CreateTennisMatchLicenseDTO;
import com.imgarena.licensing.tennis.model.Customer;
import com.imgarena.licensing.tennis.model.TennisMatch;
import com.imgarena.licensing.tennis.model.TennisMatchLicense;
import com.imgarena.licensing.tennis.repository.TennisMatchLicenseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TennisMatchLicenseService {
    private final CustomerService customerService;
    private final TennisMatchService tennisMatchService;
    private final TennisMatchLicenseRepository tennisMatchLicenseRepository;

    public TennisMatchLicense createTennisMatchLicense(CreateTennisMatchLicenseDTO createTennisMatchLicenseDTO) {
        Customer customer = customerService.getCustomer(createTennisMatchLicenseDTO.getCustomerId());
        TennisMatch tennisMatch = tennisMatchService.getTennisMatch(createTennisMatchLicenseDTO.getTennisMatchId());
        TennisMatchLicense newTennisMatchLicense = TennisMatchLicense.builder()
                .customer(customer)
                .tennisMatch(tennisMatch)
                .build();
        return tennisMatchLicenseRepository.save(newTennisMatchLicense);
    }
}
