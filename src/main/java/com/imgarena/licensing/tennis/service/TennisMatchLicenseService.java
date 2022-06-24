package com.imgarena.licensing.tennis.service;

import com.imgarena.licensing.tennis.model.TennisMatchLicense;
import com.imgarena.licensing.tennis.repository.TennisMatchLicenseRepository;
import org.springframework.stereotype.Service;

@Service
public class TennisMatchLicenseService {
    private final TennisMatchLicenseRepository tennisMatchLicenseRepository;

    public TennisMatchLicenseService(TennisMatchLicenseRepository tennisMatchLicenseRepository) {
        this.tennisMatchLicenseRepository = tennisMatchLicenseRepository;
    }

    public TennisMatchLicense createTennisMatchLicense(TennisMatchLicense tennisMatchLicense) {
        return tennisMatchLicenseRepository.save(tennisMatchLicense);
    }
}
