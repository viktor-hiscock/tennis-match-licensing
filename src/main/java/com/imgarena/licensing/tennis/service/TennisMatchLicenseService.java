package com.imgarena.licensing.tennis.service;

import com.imgarena.licensing.tennis.dto.CreateTennisMatchLicenseDTO;
import com.imgarena.licensing.tennis.exception.TennisMatchLicenseNotFoundException;
import com.imgarena.licensing.tennis.model.TennisMatch;
import com.imgarena.licensing.tennis.model.TennisMatchLicense;
import com.imgarena.licensing.tennis.repository.TennisMatchLicenseRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TennisMatchLicenseService {
    private final TennisMatchService tennisMatchService;
    private final TennisMatchLicenseRepository tennisMatchLicenseRepository;

    public TennisMatchLicense getTennisMatchLicense(Long tennisMatchLicenseId) {
        return tennisMatchLicenseRepository.findById(tennisMatchLicenseId)
                .orElseThrow(() -> new TennisMatchLicenseNotFoundException(tennisMatchLicenseId));
    }

    public TennisMatchLicense createTennisMatchLicense(CreateTennisMatchLicenseDTO createTennisMatchLicenseDTO) {
        TennisMatch tennisMatch = tennisMatchService.getTennisMatch(createTennisMatchLicenseDTO.getTennisMatchId());
        TennisMatchLicense newTennisMatchLicense = TennisMatchLicense.builder()
                .tennisMatch(tennisMatch)
                .build();
        return tennisMatchLicenseRepository.save(newTennisMatchLicense);
    }

    public TennisMatchLicense deleteTennisMatchLicense(Long tennisMatchLicenseId) {
        Optional<TennisMatchLicense> tennisMatchLicenseToDelete = tennisMatchLicenseRepository.findById(tennisMatchLicenseId);
        if (tennisMatchLicenseToDelete.isPresent()) {
            tennisMatchLicenseRepository.delete(tennisMatchLicenseToDelete.get());
        } else {
            throw new TennisMatchLicenseNotFoundException(tennisMatchLicenseId);
        }
        return tennisMatchLicenseToDelete.get();
    }

    public List<TennisMatchLicense> getAllTennisMatchLicenses(int pageNumber, int pageSize, String sortBy) {
        Pageable paging = PageRequest.of(pageNumber, pageSize, Sort.by(sortBy));
        Page<TennisMatchLicense> pagedResult = tennisMatchLicenseRepository.findAll(paging);

        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<>();
        }
    }
}
