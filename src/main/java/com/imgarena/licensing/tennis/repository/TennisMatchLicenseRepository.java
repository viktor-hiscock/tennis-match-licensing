package com.imgarena.licensing.tennis.repository;

import com.imgarena.licensing.tennis.model.TennisMatchLicense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TennisMatchLicenseRepository extends JpaRepository<TennisMatchLicense, Long> {
}
