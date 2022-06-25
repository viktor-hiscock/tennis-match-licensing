package com.imgarena.licensing.tennis.exception;

import com.imgarena.licensing.tennis.identifiers.CustomerId;

public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException(CustomerId customerId) {
        super(String.format("Customer %s does not exist", customerId.identifier()));
    }
}
