package com.imgarena.licensing.tennis.mapper;

import com.imgarena.licensing.tennis.dto.TennisTournamentLicenseResponseDTO;
import com.imgarena.licensing.tennis.model.TennisTournamentLicense;

public class TennisTournamentLicenseMapper {
    public static TennisTournamentLicenseResponseDTO convertToTennisTournamentLicenseResponseDTO(TennisTournamentLicense tennisTournamentLicense) {
        return TennisTournamentLicenseResponseDTO.builder()
                .tennisTournamentLicenseId(tennisTournamentLicense.getId())
                .tennisTournament(TennisTournamentMapper.convertToTennisTournamentResponseDTO(tennisTournamentLicense.getTennisTournament()))
                .build();
    }
}
