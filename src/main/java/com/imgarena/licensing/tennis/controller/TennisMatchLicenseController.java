package com.imgarena.licensing.tennis.controller;

import com.imgarena.licensing.tennis.dto.TennisMatchLicenseDTO;
import com.imgarena.licensing.tennis.service.TennisMatchLicenseService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class TennisMatchLicenseController {
    private final TennisMatchLicenseService tennisMatchLicenseService;

    @PostMapping("v1/license/tennis/match")
    public ResponseEntity<?> createTennisMatchLicense(@RequestBody @Validated TennisMatchLicenseDTO tennisMatchLicenseDTO) {
        return ResponseEntity.ok().build();
    }
}
