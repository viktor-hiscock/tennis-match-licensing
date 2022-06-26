package com.imgarena.licensing.tennis.controller;

import com.imgarena.licensing.tennis.dto.CreateTennisMatchLicenseDTO;
import com.imgarena.licensing.tennis.dto.TennisMatchLicenseResponseDTO;
import com.imgarena.licensing.tennis.mapper.TennisMatchLicenseMapper;
import com.imgarena.licensing.tennis.model.TennisMatchLicense;
import com.imgarena.licensing.tennis.service.TennisMatchLicenseService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class TennisMatchLicenseController {
    private final TennisMatchLicenseService tennisMatchLicenseService;

    @GetMapping("v1/license/tennis/match/{tennisMatchLicenseId}")
    public ResponseEntity<TennisMatchLicenseResponseDTO> getTennisMatchLicense(@PathVariable("tennisMatchLicenseId") Long tennisMatchLicenseId) {
        TennisMatchLicense tennisMatchLicense = tennisMatchLicenseService.getTennisMatchLicense(tennisMatchLicenseId);
        return ResponseEntity.status(HttpStatus.OK)
                .body(TennisMatchLicenseMapper.convertToTennisMatchLicenseResponseDTO(tennisMatchLicense));
    }

    @PostMapping("v1/license/tennis/match")
    public ResponseEntity<TennisMatchLicenseResponseDTO> createTennisMatchLicense(@RequestBody CreateTennisMatchLicenseDTO createTennisMatchLicenseDTO) {
        TennisMatchLicense newTennisMatchLicense = tennisMatchLicenseService.createTennisMatchLicense(createTennisMatchLicenseDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(TennisMatchLicenseMapper.convertToTennisMatchLicenseResponseDTO(newTennisMatchLicense));
    }
}
