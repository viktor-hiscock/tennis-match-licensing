package com.imgarena.licensing.tennis.controller;

import com.imgarena.licensing.tennis.dto.CreateTennisTournamentLicenseRequestDTO;
import com.imgarena.licensing.tennis.dto.TennisTournamentLicenseResponseDTO;
import com.imgarena.licensing.tennis.mapper.TennisTournamentLicenseMapper;
import com.imgarena.licensing.tennis.model.TennisTournamentLicense;
import com.imgarena.licensing.tennis.service.TennisTournamentLicenseService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class TennisTournamentLicenseController {
    private final TennisTournamentLicenseService tennisTournamentLicenseService;

    @PostMapping("v1/license/tennis/tournament")
    public ResponseEntity<TennisTournamentLicenseResponseDTO> createTennisTournament(@RequestBody CreateTennisTournamentLicenseRequestDTO createTennisTournamentLicenseRequestDTO) {
        TennisTournamentLicense tennisTournamentLicense = tennisTournamentLicenseService.createTennisTournamentLicense(createTennisTournamentLicenseRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(TennisTournamentLicenseMapper.convertToTennisTournamentLicenseResponseDTO(tennisTournamentLicense));
    }
}
