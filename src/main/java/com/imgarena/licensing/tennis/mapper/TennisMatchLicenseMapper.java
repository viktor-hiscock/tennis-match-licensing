package com.imgarena.licensing.tennis.mapper;

import com.imgarena.licensing.tennis.dto.TennisMatchLicenseResponseDTO;
import com.imgarena.licensing.tennis.model.TennisMatchLicense;

public class TennisMatchLicenseMapper {
    public static TennisMatchLicenseResponseDTO convertToTennisMatchLicenseResponseDTO(TennisMatchLicense tennisMatchLicense) {
        return TennisMatchLicenseResponseDTO.builder()
                .tennisMatchLicenseId(tennisMatchLicense.getId())
                .customer(CustomerMapper.convertToCustomerResponseDTO(tennisMatchLicense.getCustomer()))
                .tennisMatch(TennisMatchMapper.convertToTennisMatchResponseDTO(tennisMatchLicense.getTennisMatch()))
                .build();
    }
}
