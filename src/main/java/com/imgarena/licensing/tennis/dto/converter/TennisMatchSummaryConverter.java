package com.imgarena.licensing.tennis.dto.converter;

import com.imgarena.licensing.tennis.dto.TennisMatchSummaryType;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class TennisMatchSummaryConverter implements Converter<String, TennisMatchSummaryType> {
    @Override
    public TennisMatchSummaryType convert(String source) {
        return Arrays.stream(TennisMatchSummaryType.values())
                .filter(tennisMatchSummaryType -> source.equals(tennisMatchSummaryType.getSummaryType()))
                .findFirst()
                .orElse(TennisMatchSummaryType.AVB);
    }
}
