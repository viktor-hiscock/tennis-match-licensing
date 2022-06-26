package com.imgarena.licensing.tennis.service;

import com.imgarena.licensing.tennis.dto.CreateTennisTournamentLicenseRequestDTO;
import com.imgarena.licensing.tennis.exception.TennisTournamentLicenseNotFoundException;
import com.imgarena.licensing.tennis.model.TennisTournament;
import com.imgarena.licensing.tennis.model.TennisTournamentLicense;
import com.imgarena.licensing.tennis.repository.TennisTournamentLicenseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TennisTournamentLicenseService {
    private TennisTournamentService tennisTournamentService;
    private final TennisTournamentLicenseRepository tennisTournamentLicenseRepository;

    public TennisTournamentLicense getTennisTournamentLicense(Long tennisTournamentLicenseId) {
        return tennisTournamentLicenseRepository.findById(tennisTournamentLicenseId)
                .orElseThrow(() -> new TennisTournamentLicenseNotFoundException(tennisTournamentLicenseId));
    }

    public TennisTournamentLicense createTennisTournamentLicense(CreateTennisTournamentLicenseRequestDTO createTennisTournamentLicenseRequestDTO) {
        TennisTournament tennisTournament = tennisTournamentService.getTennisTournament(createTennisTournamentLicenseRequestDTO.getTennisTournamentId());
        TennisTournamentLicense tennisTournamentLicense = TennisTournamentLicense.builder()
                .tennisTournament(tennisTournament)
                .build();
        return tennisTournamentLicenseRepository.save(tennisTournamentLicense);
    }
}
