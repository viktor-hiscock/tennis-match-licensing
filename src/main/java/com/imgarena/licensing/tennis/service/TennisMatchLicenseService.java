package com.imgarena.licensing.tennis.service;

import com.imgarena.licensing.tennis.dto.TennisMatchLicenseRequestDTO;
import com.imgarena.licensing.tennis.exception.TennisMatchLicenseNotFoundException;
import com.imgarena.licensing.tennis.model.TennisMatch;
import com.imgarena.licensing.tennis.model.TennisMatchLicense;
import com.imgarena.licensing.tennis.repository.TennisMatchLicenseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TennisMatchLicenseService {
    private final TennisMatchService tennisMatchService;
    private final TennisMatchLicenseRepository tennisMatchLicenseRepository;
    private final PaginationService<TennisMatchLicense> tennisMatchLicensePaginationService;

    public TennisMatchLicense getTennisMatchLicense(Long tennisMatchLicenseId) {
        return tennisMatchLicenseRepository.findById(tennisMatchLicenseId)
                .orElseThrow(() -> new TennisMatchLicenseNotFoundException(tennisMatchLicenseId));
    }

    public TennisMatchLicense createTennisMatchLicense(TennisMatchLicenseRequestDTO tennisMatchLicenseRequestDTO) {
        TennisMatch tennisMatch = tennisMatchService.getTennisMatch(tennisMatchLicenseRequestDTO.getTennisMatchId());
        TennisMatchLicense newTennisMatchLicense = TennisMatchLicense.builder()
                .tennisMatch(tennisMatch)
                .build();
        return tennisMatchLicenseRepository.save(newTennisMatchLicense);
    }

    public TennisMatchLicense deleteTennisMatchLicense(Long tennisMatchLicenseId) {
        TennisMatchLicense tennisMatchLicenseToDelete = getTennisMatchLicense(tennisMatchLicenseId);
        tennisMatchLicenseRepository.delete(tennisMatchLicenseToDelete);
        return tennisMatchLicenseToDelete;
    }

    public List<TennisMatchLicense> getAllTennisMatchLicenses(int pageNumber, int pageSize) {
        return tennisMatchLicensePaginationService.getPaginatedRecords(pageNumber, pageSize, tennisMatchLicenseRepository);
    }
}
