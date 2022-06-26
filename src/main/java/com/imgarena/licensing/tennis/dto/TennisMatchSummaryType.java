package com.imgarena.licensing.tennis.dto;

import com.imgarena.licensing.tennis.model.TennisMatch;

import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

public enum TennisMatchSummaryType {
    AVB("AvB") {
        @Override
        public String getTennisMatchSummary(TennisMatch tennisMatch) {
            return String.format("%s vs %s", tennisMatch.getPlayerA().getFullName(), tennisMatch.getPlayerB().getFullName());
        }
    },
    AVB_TIME("AvBTime") {
        @Override
        public String getTennisMatchSummary(TennisMatch tennisMatch) {
            ZonedDateTime startDate = ZonedDateTime.of(tennisMatch.getStartDate(), tennisMatch.getZoneId());
            Long timeSinceMatchStartedInMinutes = ChronoUnit.MINUTES.between(startDate, ZonedDateTime.now());
            return String.format(
                    "%s vs %s, started %d minutes ago",
                    tennisMatch.getPlayerA().getFullName(),
                    tennisMatch.getPlayerB().getFullName(),
                    timeSinceMatchStartedInMinutes
            );
        }
    };

    private final String summaryType;

    TennisMatchSummaryType(String summaryType) {
        this.summaryType = summaryType;
    }

    public String getSummaryType() {
        return summaryType;
    }

    public String getTennisMatchSummary(TennisMatch tennisMatch) {
        return "";
    }
}
