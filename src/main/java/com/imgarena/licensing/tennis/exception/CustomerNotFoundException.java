package com.imgarena.licensing.tennis.exception;

public class CustomerNotFoundException extends RuntimeException implements ResourceNotFoundException {
    public CustomerNotFoundException(Long customerId) {
        super(String.format("Customer %s does not exist", customerId));
    }

    @Override
    public String getCode() {
        return BusinessErrorCode.CUSTOMER_NOT_FOUND.getErrorCode();
    }
}
