package com.imgarena.licensing.tennis.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CreateCustomerRequestDTO {
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private List<Long> tennisMatchLicenseIds;
}
