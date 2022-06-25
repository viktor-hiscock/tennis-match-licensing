package com.imgarena.licensing.tennis.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomerResponseDTO {
    private String customerId;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String createdAt;
}
