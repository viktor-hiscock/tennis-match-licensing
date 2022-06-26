package com.imgarena.licensing.tennis.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = TableNames.TENNIS_TOURNAMENT_LICENSE)
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TennisTournamentLicense {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long id;

    @OneToOne
    @JoinColumn(name = "CUSTOMER_ID", referencedColumnName = "ID")
    private Customer customer;

    @OneToOne
    @JoinColumn(name = "TENNIS_TOURNAMENT_LICENSE_ID", referencedColumnName = "ID")
    private TennisTournament tennisTournament;
}
