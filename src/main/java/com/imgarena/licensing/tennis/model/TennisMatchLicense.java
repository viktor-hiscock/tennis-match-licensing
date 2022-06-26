package com.imgarena.licensing.tennis.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = TableNames.TENNIS_MATCH_LICENSE)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TennisMatchLicense {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "TENNIS_MATCH_ID", referencedColumnName = "ID")
    private TennisMatch tennisMatch;
}
