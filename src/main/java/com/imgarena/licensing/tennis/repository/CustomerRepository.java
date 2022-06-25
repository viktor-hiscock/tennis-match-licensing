package com.imgarena.licensing.tennis.repository;

import com.imgarena.licensing.tennis.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
