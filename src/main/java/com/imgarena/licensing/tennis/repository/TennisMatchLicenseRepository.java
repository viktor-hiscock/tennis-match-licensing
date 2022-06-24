package com.imgarena.licensing.tennis.repository;

import com.imgarena.licensing.tennis.model.TennisMatchLicenseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TennisMatchLicenseRepository extends JpaRepository<TennisMatchLicenseEntity, UUID> {
}
