package com.imgarena.licensing.tennis.exception;

public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException(Long customerId) {
        super(String.format("Customer %s does not exist", customerId));
    }
}
