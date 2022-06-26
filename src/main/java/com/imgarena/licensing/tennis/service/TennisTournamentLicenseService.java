package com.imgarena.licensing.tennis.service;

import com.imgarena.licensing.tennis.dto.TennisTournamentLicenseRequestDTO;
import com.imgarena.licensing.tennis.exception.TennisTournamentLicenseNotFoundException;
import com.imgarena.licensing.tennis.model.TennisTournament;
import com.imgarena.licensing.tennis.model.TennisTournamentLicense;
import com.imgarena.licensing.tennis.repository.TennisTournamentLicenseRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class TennisTournamentLicenseService {
    private TennisTournamentService tennisTournamentService;
    private final TennisTournamentLicenseRepository tennisTournamentLicenseRepository;
    private final PaginationService<TennisTournamentLicense> tennisTournamentLicensePaginationService;

    public TennisTournamentLicense getTennisTournamentLicense(Long tennisTournamentLicenseId) {
        return tennisTournamentLicenseRepository.findById(tennisTournamentLicenseId)
                .orElseThrow(() -> new TennisTournamentLicenseNotFoundException(tennisTournamentLicenseId));
    }

    public TennisTournamentLicense createTennisTournamentLicense(TennisTournamentLicenseRequestDTO tennisTournamentLicenseRequestDTO) {
        TennisTournament tennisTournament = tennisTournamentService.getTennisTournament(tennisTournamentLicenseRequestDTO.getTennisTournamentId());
        TennisTournamentLicense tennisTournamentLicense = TennisTournamentLicense.builder()
                .tennisTournament(tennisTournament)
                .build();
        return tennisTournamentLicenseRepository.save(tennisTournamentLicense);
    }

    public TennisTournamentLicense deleteTennisTournamentLicense(Long tennisTournamentLicenseId) {
        TennisTournamentLicense tennisTournamentLicenseToDelete = getTennisTournamentLicense(tennisTournamentLicenseId);
        tennisTournamentLicenseRepository.delete(tennisTournamentLicenseToDelete);
        return tennisTournamentLicenseToDelete;
    }

    public List<TennisTournamentLicense> getAllTennisTournamentLicenses(int pageNumber, int pageSize) {
        return tennisTournamentLicensePaginationService.getPaginatedRecords(pageNumber, pageSize, tennisTournamentLicenseRepository);
    }
}
