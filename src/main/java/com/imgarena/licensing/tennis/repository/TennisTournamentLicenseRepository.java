package com.imgarena.licensing.tennis.repository;

import com.imgarena.licensing.tennis.model.TennisTournamentLicense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TennisTournamentLicenseRepository extends JpaRepository<TennisTournamentLicense, Long> {
}
