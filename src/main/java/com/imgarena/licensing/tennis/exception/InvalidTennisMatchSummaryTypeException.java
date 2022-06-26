package com.imgarena.licensing.tennis.exception;

public class InvalidTennisMatchSummaryTypeException extends RuntimeException {
    public InvalidTennisMatchSummaryTypeException(String summaryType) {
        super(String.format("%s is not a valid summary type", summaryType));
    }
}
