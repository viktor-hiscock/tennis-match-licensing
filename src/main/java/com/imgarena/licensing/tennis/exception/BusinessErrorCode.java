package com.imgarena.licensing.tennis.exception;

public enum BusinessErrorCode {
    CUSTOMER_NOT_FOUND("IMG-0001"),
    TENNIS_PLAYER_NOT_FOUND("IMG-0002"),
    TENNIS_MATCH_NOT_FOUND("IMG-0003"),
    TENNIS_TOURNAMENT_NOT_FOUND("IMG-0004"),
    TENNIS_MATCH_LICENSE_NOT_FOUND("IMG-0005"),
    TENNIS_TOURNAMENT_LICENSE_NOT_FOUND("IMG-0006");

    private final String errorCode;

    BusinessErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
