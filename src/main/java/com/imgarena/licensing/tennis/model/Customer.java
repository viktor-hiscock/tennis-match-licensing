package com.imgarena.licensing.tennis.model;

import com.imgarena.licensing.tennis.identifiers.CustomerId;
import com.imgarena.licensing.tennis.model.converter.CustomerIdConverter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = TableNames.CUSTOMER)
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Customer {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Convert(converter = CustomerIdConverter.class)
    private CustomerId customerId;

    private String firstName;

    private String lastName;

    private LocalDate dateOfBirth;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
