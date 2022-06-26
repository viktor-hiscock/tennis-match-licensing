package com.imgarena.licensing.tennis.controller;

import com.imgarena.licensing.tennis.dto.TennisTournamentLicenseRequestDTO;
import com.imgarena.licensing.tennis.dto.TennisTournamentLicenseResponseDTO;
import com.imgarena.licensing.tennis.mapper.TennisTournamentLicenseMapper;
import com.imgarena.licensing.tennis.model.TennisTournamentLicense;
import com.imgarena.licensing.tennis.service.TennisTournamentLicenseService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class TennisTournamentLicenseController {
    private final TennisTournamentLicenseService tennisTournamentLicenseService;

    @GetMapping("v1/license/tennis/tournament/{tennisTournamentLicenseId}")
    public ResponseEntity<TennisTournamentLicenseResponseDTO> getTennisTournamentLicense(@PathVariable("tennisTournamentLicenseId") Long tennisTournamentLicenseId) {
        TennisTournamentLicense tennisTournamentLicense = tennisTournamentLicenseService.getTennisTournamentLicense(tennisTournamentLicenseId);
        return ResponseEntity.status(HttpStatus.OK)
                .body(TennisTournamentLicenseMapper.convertToTennisTournamentLicenseResponseDTO(tennisTournamentLicense));
    }

    @PostMapping("v1/license/tennis/tournament")
    public ResponseEntity<TennisTournamentLicenseResponseDTO> createTennisTournamentLicense(@RequestBody TennisTournamentLicenseRequestDTO tennisTournamentLicenseRequestDTO) {
        TennisTournamentLicense tennisTournamentLicense = tennisTournamentLicenseService.createTennisTournamentLicense(tennisTournamentLicenseRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(TennisTournamentLicenseMapper.convertToTennisTournamentLicenseResponseDTO(tennisTournamentLicense));
    }

    @DeleteMapping("v1/license/tennis/tournament/{tennisTournamentLicenseId}")
    public ResponseEntity<TennisTournamentLicenseResponseDTO> deleteTennisTournamentLicense(@PathVariable("tennisTournamentLicenseId") Long tennisTournamentLicenseId) {
        TennisTournamentLicense deletedTennisTournamentLicense = tennisTournamentLicenseService.deleteTennisTournamentLicense(tennisTournamentLicenseId);
        return ResponseEntity.status(HttpStatus.OK)
                .body(TennisTournamentLicenseMapper.convertToTennisTournamentLicenseResponseDTO(deletedTennisTournamentLicense));
    }
    @GetMapping("v1/license/tennis/tournament")
    public ResponseEntity<List<TennisTournamentLicenseResponseDTO>> getAllTennisTournamentLicenses(
            @RequestParam(defaultValue = "0") int pageNumber,
            @RequestParam(defaultValue = "10") int pageSize,
            @RequestParam(defaultValue = "id") String sortBy
    ) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(tennisTournamentLicenseService.getAllTennisTournamentLicenses(pageNumber, pageSize, sortBy).stream()
                        .map(TennisTournamentLicenseMapper::convertToTennisTournamentLicenseResponseDTO)
                        .collect(Collectors.toList()));
    }
}
