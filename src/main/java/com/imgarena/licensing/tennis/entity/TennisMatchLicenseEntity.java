package com.imgarena.licensing.tennis.entity;

import com.imgarena.licensing.tennis.identifiers.CustomerId;
import com.imgarena.licensing.tennis.entity.converter.CustomerIdConverter;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = TableNames.TENNIS_MATCH_LICENSE)
@Data
@NoArgsConstructor
public class TennisMatchLicenseEntity {
    @Id
    private UUID id;

    @Convert(converter = CustomerIdConverter.class)
    private CustomerId customerId;

    @OneToOne
    @JoinColumn(name = "TENNIS_MATCH_ID", referencedColumnName = "ID")
    private TennisMatchEntity tennisMatch;
}
